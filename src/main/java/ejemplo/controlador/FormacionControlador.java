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

import ejemplo.modelo.entidad.Formacion;
import ejemplo.modelo.propertyEditor.FormacionPropertyEditor;
import ejemplo.modelo.repositorio.RepositorioFormacion;



@Controller
@RequestMapping ("/formacion")
public class FormacionControlador {

	@Autowired
	private RepositorioFormacion repoForma;
	
	@Autowired
	private FormacionPropertyEditor formacionPropertyEditor;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String guardarFormacion(Model model, @Valid @ModelAttribute Formacion formacion, BindingResult bindingResult) {
		repoForma.save(formacion);
		model.addAttribute("formacion", repoForma.findAll());
		return "*/*";
	}
	
	@RequestMapping(value = " /{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> borrarFormacion(@PathVariable long id) {
		try {
			repoForma.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Formacion editarFormacion(@PathVariable Long id){
		return repoForma.findOne(id);
		
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Formacion.class, formacionPropertyEditor);
	}
	
	
	
}
