package ejemplo.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import ejemplo.modelo.entidad.Candidato;
import ejemplo.modelo.entidad.Oferta;
import ejemplo.modelo.propertyEditor.OfertaPropertyEditor;
import ejemplo.modelo.repositorio.RepositorioCandidato;
import ejemplo.modelo.repositorio.RepositorioOferta;

@Controller
@RequestMapping("/oferta")
public class OfertaControlador {

	@Autowired
	private RepositorioOferta repoOfer;
	@Autowired
	private RepositorioCandidato repoCandi;
	@Autowired
	private OfertaPropertyEditor oferprop;

	@RequestMapping(method = RequestMethod.GET)
	public String listaOferta(Model model)
	{
		model.addAttribute("oferta",repoOfer.findAll());
		return "pages/oferta";
	}

	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	private String detallesOfertaEmpresa (Model model, @PathVariable long id){
		
		model.addAttribute("oferta", repoOfer.findOne(id));
		return "page/detalleOfertasEmpresa";

	}
	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> borrarCandidato(@PathVariable long id){
		try {
			repoCandi.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}
	@RequestMapping(method=RequestMethod.GET, value="/o{id}")
	@ResponseBody
	public Oferta buscarOferta(@PathVariable Long id)
	{
		Oferta orf =repoOfer.findOne(id);
		return orf;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/inscribirse/{id}")
	public String inscribirCandidato( Model model, @Valid @ModelAttribute Candidato candidato, BindingResult bindingResult) {
		repoCandi.save(candidato);
		model.addAttribute("candidato",repoCandi.findAll());
		return "pages/empresaListado";

	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Oferta.class, oferprop);
	}
}
