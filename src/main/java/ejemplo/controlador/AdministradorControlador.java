package ejemplo.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ejemplo.modelo.entidad.Candidato;
import ejemplo.modelo.entidad.Curriculum;
import ejemplo.modelo.entidad.Empresa;
import ejemplo.modelo.entidad.Experiencia;
import ejemplo.modelo.entidad.Formacion;
import ejemplo.modelo.entidad.Idioma;
import ejemplo.modelo.entidad.Oferta;
import ejemplo.modelo.repositorio.RepositorioCandidato;
import ejemplo.modelo.repositorio.RepositorioCurriculum;
import ejemplo.modelo.repositorio.RepositorioEmpresa;
import ejemplo.modelo.repositorio.RepositorioExperiencia;
import ejemplo.modelo.repositorio.RepositorioFormacion;
import ejemplo.modelo.repositorio.RepositorioIdioma;
import ejemplo.modelo.repositorio.RepositorioOferta;

@Controller
@RequestMapping("/administrador")
public class AdministradorControlador {
	
	@Autowired
	private RepositorioEmpresa repoEmp;
	@Autowired
	private RepositorioOferta repoOfer;
	@Autowired
	private RepositorioCandidato repoCandi;
	@Autowired
	private RepositorioCurriculum repoCV;
	@Autowired
	private RepositorioExperiencia repoExpe;
	@Autowired
	private RepositorioFormacion repoForm;
	@Autowired
	private RepositorioIdioma repoIdioma;
	
	
	
//	@RequestMapping(method = RequestMethod.POST)
//	public String guardarEmpresa(Model model, @Valid @ModelAttribute Empresa empresa, BindingResult bindingResult)
//	{
//		repoEmp.save(empresa);
//		model.addAttribute("empresa",repoEmp.findAll());
//		return "pages/empresaListado";
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public String guardarOferta(Model model, @Valid @ModelAttribute Oferta oferta, BindingResult bindingResult)
//	{
//		repoOfer.save(oferta);
//		model.addAttribute("oferta",repoOfer.findAll());
//		return "pages/empresaListado";
//	}
//	@RequestMapping(method = RequestMethod.POST)
//	public String guardarCandidato(Model model, @Valid @ModelAttribute Candidato candidato, BindingResult bindingResult)
//	{
//		repoCandi.save(candidato);
//		model.addAttribute("candidato",repoCandi.findAll());
//		return "pages/empresaListado";
//	}
//	
//	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
//	public ResponseEntity<String> borrarEmpresa(@PathVariable long id){
//		try {
//			repoEmp.delete(id);
//			return new ResponseEntity<String>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
//	public ResponseEntity<String> borraroferta(@PathVariable long id){
//		try {
//			repoOfer.delete(id);
//			return new ResponseEntity<String>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
//	public ResponseEntity<String> borrarCandidato (@PathVariable long id){
//		try {
//			repoCandi.delete(id);
//			return new ResponseEntity<String>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public String guardarCurriculim(Model model, @Valid @ModelAttribute Curriculum cv, BindingResult bindingResult)
//	{
//		repoCV.save(cv);
//		model.addAttribute("curriculum",repoCV.findAll());
//		return "pages/candidatoCV";
//	}
//	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
//	public ResponseEntity<String> borrarCurriculum (@PathVariable long id){
//		try {
//		
//			repoCV.delete(id);
//			return new ResponseEntity<String>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public String guardarCurriculim(Model model, @Valid @ModelAttribute Experiencia experiencia, BindingResult bindingResult)
//	{
//		repoExpe.save(experiencia);
//		model.addAttribute("experiencia",repoExpe.findAll());
//		return "pages/experiencia";
//	}
//	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
//	public ResponseEntity<String> borrarExperiencia (@PathVariable long id){
//		try {
//			repoExpe.delete(id);
//			return new ResponseEntity<String>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public String guardarFormacion (Model model, @Valid @ModelAttribute Formacion formacion, BindingResult bindingResult)
//	{
//		repoForm.save(formacion);
//		model.addAttribute("formacion",repoForm.findAll());
//		return "pages/formacion";
//	}
//	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
//	public ResponseEntity<String> borrarFormacion (@PathVariable long id){
//		try {
//			repoForm.delete(id);
//			return new ResponseEntity<String>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	@RequestMapping(method = RequestMethod.POST)
//	public String guardarIdioma (Model model, @Valid @ModelAttribute Idioma idioma, BindingResult bindingResult)
//	{
//		repoIdioma.save(idioma);
//		model.addAttribute("idioma",repoIdioma.findAll());
//		return "pages/idioma";
//	}
//	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
//	public ResponseEntity<String> borrarIdioma (@PathVariable long id){
//		try {
//			repoIdioma.delete(id);
//			return new ResponseEntity<String>(HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//		}
//	}
}
