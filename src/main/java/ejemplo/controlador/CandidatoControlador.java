package ejemplo.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ejemplo.modelo.entidad.Candidato;
import ejemplo.modelo.propertyEditor.RolPropertyEditor;
import ejemplo.modelo.repositorio.RepositorioCandidato;

@Controller
@RequestMapping("/candidato")
public class CandidatoControlador {
	
	@Autowired
	private RepositorioCandidato repoCandidato;

	@Autowired
	private RolPropertyEditor roleProperty;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String loginInicio(Model model, @Valid @ModelAttribute Candidato per, BindingResult bindingResult) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		repoCandidato.save(per);
		model.addAttribute("Mensaje", "Se ha registrado correctamente");
		return "index";
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public String listarCandidato(Model model) {
		model.addAttribute("candidato", repoCandidato.findAll());
		return "";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Role.class, roleProperty);
	}
}
