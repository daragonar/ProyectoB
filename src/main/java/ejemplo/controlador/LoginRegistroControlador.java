package ejemplo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Login")
public class LoginRegistroControlador {

	@RequestMapping(method = RequestMethod.GET)
	public String loginInicio()
	{
		return "pages/login";
	}
	
	@RequestMapping(value = "/regEmpresa",method = RequestMethod.POST)
	public String registrarEmpresa(Model model,@Valid @ModelAttribute Empresa empresa)
	{
		repoEmp.save(empresa);
		model.addAttribute("RegistroCorrecto" , "Su empresa se ha registrado Correctamente");
		return "pages/login";
	}
	
	@RequestMapping(value = "/regPersona",method = RequestMethod.POST)
	public String registrarEmpresa(Model model,@Valid @ModelAttribute Persona persona)
	{
		repoPersona.save(persona);
		model.addAttribute("RegistroCorrecto" , "Su empresa se ha registrado Correctamente");
		return "pages/login";
	}
	
	@RequestMapping(value = "/regAdmin",method = RequestMethod.POST)
	public String registrarEmpresa(Model model,@Valid @ModelAttribute Admin admin)
	{
		repoAdmin.save(admin);
		model.addAttribute("RegistroCorrecto" , "Su empresa se ha registrado Correctamente");
		return "pages/login";
	}

}
