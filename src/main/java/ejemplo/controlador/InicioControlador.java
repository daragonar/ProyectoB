package ejemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioControlador {
	
	@RequestMapping(value="/")
	public String index()
	{
		return "index";
	}
}
