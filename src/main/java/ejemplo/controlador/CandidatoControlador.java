package ejemplo.controller;

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

@Controller
@RequestMapping("/")
public class CandidatoControlador {
	@Autowired
	private CandidatoRepositorio repoCandidato;

	@Autowired
	private RolePropertyEditor roleProperty;

	@RequestMapping(method = RequestMethod.GET, value = { "/login", "/" })
	public String loginInicio(Model model) {

		return "index";
	}

	@RequestMapping(method = RequestMethod.POST, value = { "/login", "/" })
	public String loginInicio(Model model, @Valid @ModelAttribute Usuario per, BindingResult bindingResult) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		per.setContrasena(encoder.encode(per.getPassword()));
		repoCandidato.save(per);
		model.addAttribute("Mensaje", "Se ha registrado correctamente");
		return "index";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Role.class, roleProperty);
	}
}
