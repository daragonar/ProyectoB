<<<<<<< HEAD
package ejemplo.controlador;
=======
package ejemplo.controller;
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c
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

<<<<<<< HEAD
import ejemplo.modelo.entidad.Candidato;
import ejemplo.modelo.entidad.Oferta;
import ejemplo.modelo.repositorio.RepositorioCandidato;
import ejemplo.modelo.repositorio.RepositorioOferta;

=======
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c
@Controller
@RequestMapping("/oferta")
public class OfertaControlador {

	@Autowired
<<<<<<< HEAD
	private RepositorioOferta repoOfer;
	@Autowired
	private RepositorioCandidato repoCandi;
=======
	private OfertaRepositorio repoOfer;
	@Autowired
	private CandidatoRepositorio repoCandi;
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c

	@RequestMapping(method = RequestMethod.GET)
	public String listaOferta(Model model)
	{
<<<<<<< HEAD
		model.addAttribute("oferta",repoOfer.findAll());
		return "pages/oferta";
	}

	@RequestMapping(method=RequestMethod.GET,value="/oferta/{id}")
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
=======
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
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c
		}
	}
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
<<<<<<< HEAD
	public Oferta buscarOferta(@PathVariable Long id)
	{
		Oferta orf =repoOfer.findOne(id);
		return orf;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public String inscribirCandidato( Model model, @Valid @ModelAttribute Candidato candidato, BindingResult bindingResult) {
		repoCandi.save(candidato);
=======
	public Ofeta buscarOferta(@PathVariable Long id)
	{
		Oferta orf =orfRepo.findOne(id);
		return orf;
	}
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Candidato inscribirCandidato( Model model, @Valid @ModelAttribute Candidato candidato, BindingResult bindingResult) {
		candiRepo.save(candidato);
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c
		model.addAttribute("candidato",repoCandi.findAll());
		return "pages/empresaListado";

	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Oferta.class, oferprop);
	}
	
}
