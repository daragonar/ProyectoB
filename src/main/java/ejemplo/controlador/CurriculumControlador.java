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

import ejemplo.modelo.entidad.Curriculum;
import ejemplo.modelo.propertyEditor.CurriculumPropertyEditor;
import ejemplo.modelo.repositorio.RepositorioCurriculum;


@Controller
@RequestMapping ("/curriculum")
public class CurriculumControlador {
	
	@Autowired
	private RepositorioCurriculum repoCurr;
	@Autowired
	private CurriculumPropertyEditor curriculumPropertyEditor;

	@RequestMapping(method = RequestMethod.POST)
	public String anadirCurriculum(Model model, @Valid @ModelAttribute Curriculum curriculum, BindingResult bindingResult) {
		repoCurr.save(curriculum);
		model.addAttribute("curriculum", repoCurr.findAll());
		return "pages/curriculumListado";
	}
	
	@RequestMapping(value = " /{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> borrarCurriculum(@PathVariable long id) {
		try {
			repoCurr.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public Curriculum editarCurriculum(@PathVariable Long id) {
		Curriculum curriculum = repoCurr.findOne(id);
		return curriculum;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Curriculum.class, curriculumPropertyEditor);
	}
	
}
