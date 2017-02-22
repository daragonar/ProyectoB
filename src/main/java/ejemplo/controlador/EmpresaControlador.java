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

import ejemplo.modelo.entidad.Empresa;
import ejemplo.modelo.entidad.Oferta;
import ejemplo.modelo.propertyEditor.EmpresaPropertyEditor;
import ejemplo.modelo.repositorio.RepositorioEmpresa;
import ejemplo.modelo.repositorio.RepositorioOferta;

@Controller
@RequestMapping("/empresa")
public class EmpresaControlador {

	@Autowired
	private RepositorioEmpresa repoEmp;
	@Autowired
	private RepositorioOferta repoOfer;
	@Autowired
	private EmpresaPropertyEditor empreprop;

	@RequestMapping(method = RequestMethod.GET)
	public String listaEmpresa(Model model) {
		model.addAttribute("empresas", repoEmp.findAll());
		return "pages/empresas";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/detalle/{id}")
	public String detalleEmpresa(Model model, @PathVariable long id) {
		model.addAttribute("empresa", repoEmp.findOne(id));
		return "pages/detalleEmpresa";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/oferta/{id}")
	private String detallesOfertaEmpresa(Model model, @PathVariable long id) {

		model.addAttribute("oferta", repoOfer.findOne(id));
		return "page/detalleOfertasEmpresa";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardarEmpresa(Model model, @Valid @ModelAttribute Empresa empresa, BindingResult bindingResult) {
		repoEmp.save(empresa);
		model.addAttribute("empresa", repoEmp.findAll());
		return "pages/empresaListado";
	}

	@RequestMapping(value = "/oferta", method = RequestMethod.POST)
	public String guardarOferta(Model model, @Valid @ModelAttribute Oferta oferta, BindingResult bindingResult) {
		repoOfer.save(oferta);
		model.addAttribute("oferta", repoOfer.findAll());
		return "pages/empresaListado";
	}

	@RequestMapping(value = " /{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> borrarEmpresa(@PathVariable long id) {
		try {
			repoEmp.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = " /oferta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> borraroferta(@PathVariable long id) {
		try {
			repoOfer.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public Empresa buscarEmpresa(@PathVariable Long id) {
		Empresa empr = repoEmp.findOne(id);
		return empr;
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Empresa.class, empreprop);
	}
}
