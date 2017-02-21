package ejemplo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@Controller
@RequestMapping("/oferta")
public class OfertaControlador {

	@Autowired
	private OfertaRepositorio repoOfer;
	@Autowired
	private CandidatoRepositorio repoCandi;

	@RequestMapping(method = RequestMethod.GET)
	public String listaOferta(Model model)
	{
		model.addAttribute("oferta",repoOfer.FindAll())
		return "pages/oferta";
	}

	@RequestMapping(method=RequestMapping.GET,value="/oferta/{id}")
	private String detallesOfertaEmpresa (Model model, @PathVariable long id){
		
		model.addAllAttributes("oferta", repoOfer.findOne(Oferta.id))
		return "page/detalleOfertasEmpresa"

	}
	@RequestMapping(value =" /{id}", method= RequestMethod.Delete)
	public ReponseEntity<String> borrarCandidato(@PathVariable long id){
		try {
			CandidatoRepo.delete(id);
			return new ReponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ReponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Ofeta buscarOferta(@PathVariable Long id)
	{
		Oferta orf =orfRepo.findOne(id);
		return orf;
	}
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Candidato inscribirCandidato( Model model, @Valid @ModelAttribute Candidato candidato, BindingResult bindingResult) {
		candiRepo.save(candidato);
		model.addAttribute("candidato",repoCandi.findAll());
		return "pages/empresaListado";

	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Oferta.class, oferprop);
	}
	
}
