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

import ejemplo.modelo.entidad.Idioma;
import ejemplo.modelo.propertyEditor.IdiomaPropertyEditor;
import ejemplo.modelo.repositorio.RepositorioIdioma;

@Controller
@RequestMapping("/idioma")
public class IdiomaControlador {
	
	@Autowired
	private RepositorioIdioma idiomaRepo;
	@Autowired
	private IdiomaPropertyEditor idiomaPropertyEditor;
	
	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> borrarIdioma(@PathVariable long id){
		try {
			idiomaRepo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Idioma editarIdioma(@PathVariable Long id){
		return idiomaRepo.findOne(id);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String guardarIdioma(Model model, @Valid @ModelAttribute Idioma idioma, BindingResult bindingResult)
	{
		idiomaRepo.save(idioma);
		model.addAttribute("experiencia",idiomaRepo.findAll());
		return "jai";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Idioma.class, idiomaPropertyEditor);
	}

}
