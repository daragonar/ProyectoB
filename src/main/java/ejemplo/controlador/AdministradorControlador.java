package ejemplo.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/administrador")
public class AdministradorControlador {
	
	@Autowired
	private RepositorioEmpresa repoEmp;
	@Autowired
	private RepositorioOferta repoOfer;
	@Autowired
	private RepositorioCandidato repoCandi;

	@Autowired
	private RolePropertyEditor roleProperty;
	
	@RequestMapping(method = RequestMethod.POST)
	public String guardarEmpresa(Model model, @Valid @ModelAttribute Empresa empresa, BindingResult bindingResult)
	{
		repoEmp.save(empresa);
		model.addAttribute("empresa",repoEmp.findAll());
		return "pages/empresaListado";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String guardarOferta(Model model, @Valid @ModelAttribute Oferta oferta, BindingResult bindingResult)
	{
		repoOfer.save(oferta);
		model.addAttribute("oferta",repoOfer.findAll());
		return "pages/empresaListado";
	}
	
	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> borrarEmpresa(@PathVariable long id){
		try {
			repoEmp.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> borraroferta(@PathVariable long id){
		try {
			repoOfer.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value =" /{id}", method= RequestMethod.DELETE)
	public ResponseEntity<String> borrarCandidato (@PathVariable long id){
		try {
			repoCandi.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
