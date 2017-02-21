package ejemplo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioControlador {

		
//		@Autowired
//		private repositorioRoles reposiRoles;
	//	
		@RequestMapping(value = "/", method = RequestMethod.GET)
	    public String index(Model model){
//			
//			reposiRoles.save(new Permiso((long) 1, "ADMIN"));
//			reposiRoles.save(new Permiso((long) 2, "CANDIDATO"));
//			reposiRoles.save(new Permiso((long) 2, "EMPRESA"));
//			
			
			return "index";
	    }
}

