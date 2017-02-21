package ejemplo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ejemplo.modelo.repositorio.RepositorioEmpresa;
import ejemplo.modelo.repositorio.RepositorioOferta;

@Controller
@RequestMapping("/buscar")
public class BuscadorControlador {
	
	@Autowired
	private RepositorioEmpresa empreRepo;
	@Autowired
	private RepositorioOferta oferRepo;
	
	
	@RequestMapping(method= RequestMethod.GET)
	public String inicio (Model model){
		
		return "busqueda";
	}
	
	@RequestMapping (method= RequestMethod.POST)
	public String buscar (@RequestParam String buscar, Model model ){
		model.addAttribute("titulo", "BUSQUEDA");
		model.addAttribute("titulo1", "EMPRESA");
		model.addAttribute("titulo2", "OFERTA");
		
		model.addAttribute("empresa", empreRepo.findByNombreIgnoreCaseContaining(buscar));
		model.addAttribute("oferta", oferRepo.findByNombreIgnoreCaseContaining(buscar));
			
		return "busqueda";
		
	}
	
	
}
