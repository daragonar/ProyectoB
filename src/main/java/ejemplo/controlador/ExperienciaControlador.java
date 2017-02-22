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

import ejemplo.modelo.entidad.Experiencia;
import ejemplo.modelo.propertyEditor.ExperienciaPropertyEditor;
import ejemplo.modelo.repositorio.RepositorioExperiencia;




@Controller
@RequestMapping ( "/experiencia")
public class ExperienciaControlador {
	
	@Autowired
	private RepositorioExperiencia expeRepo;
	
	@Autowired
	private ExperienciaPropertyEditor experienciaPropertyEditor;
	
	@RequestMapping(method = RequestMethod.POST)
	public String guardarExperiencia(Model model, @Valid @ModelAttribute Experiencia experiencia, BindingResult bindingResult)
	{
		expeRepo.save(experiencia);
		model.addAttribute("experiencia",expeRepo.findAll());
		return "**";
	}
	
	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> borrarEmpresa(@PathVariable long id){
		try {
			expeRepo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Experiencia editarExperiencia(@PathVariable Long id){
		return expeRepo.findOne(id);
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Experiencia.class, experienciaPropertyEditor);
	}

}
