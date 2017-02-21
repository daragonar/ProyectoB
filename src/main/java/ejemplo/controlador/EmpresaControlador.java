<<<<<<< HEAD
package ejemplo.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
=======
package ejemplo.controller;

import javax.validation.Valid;

import org.empleodigital.domain.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c
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

<<<<<<< HEAD
import ejemplo.modelo.entidad.Empresa;
import ejemplo.modelo.entidad.Oferta;
import ejemplo.modelo.repositorio.RepositorioEmpresa;
import ejemplo.modelo.repositorio.RepositorioOferta;

=======
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c


@Controller
@RequestMapping("/empresa")
public class EmpresaControlador {

	@Autowired
<<<<<<< HEAD
	private RepositorioEmpresa repoEmp;
	@Autowired
	private RepositorioOferta repoOfer;
=======
	private EmpresaRepositorio repoEmp;
	@Autowired
	private OfertaRepositorio repoOfer;
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c

	
	@RequestMapping(method = RequestMethod.GET)
	public String listaEmpresa(Model model)
	{
<<<<<<< HEAD
		model.addAttribute("empresas",repoEmp.findAll());
=======
		model.addAttribute("empresas",repoEmp.FindAll())
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c
		return "pages/empresas";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public String detalleEmpresa(Model model, @PathVariable long id)
	{
		model.addAttribute("empresa", repoEmp.findOne(id));
		return "pages/detalleEmpresa";
	}
	
<<<<<<< HEAD
	@RequestMapping(method=RequestMethod.GET,value="/oferta/{id}")
	private String detallesOfertaEmpresa (Model model, @PathVariable long id){
		
		model.addAttribute("oferta", repoOfer.findOne(id));
		return "page/detalleOfertasEmpresa";
=======
	@RequestMapping(method=RequestMapping.GET,value="/oferta/{id}")
	private String detallesOfertaEmpresa (Model model, @PathVariable long id){
		
		model.addAllAttributes("oferta", repoOfer.findOne(Oferta.id))
		return "page/detalleOfertasEmpresa"
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c

	}
	@RequestMapping(method = RequestMethod.POST)
	public String guardarEmpresa(Model model, @Valid @ModelAttribute Empresa empresa, BindingResult bindingResult)
	{
<<<<<<< HEAD
		repoEmp.save(empresa);
=======
		empresaRepo.save(empresa);
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c
		model.addAttribute("empresa",repoEmp.findAll());
		return "pages/empresaListado";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String guardarOferta(Model model, @Valid @ModelAttribute Oferta oferta, BindingResult bindingResult)
	{
<<<<<<< HEAD
		repoOfer.save(oferta);
=======
		oferRepo.save(oferta);
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c
		model.addAttribute("oferta",repoOfer.findAll());
		return "pages/empresaListado";
	}
	
<<<<<<< HEAD
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
=======
	@RequestMapping(value =" /{id}", method= RequestMethod.Delete)
	public ReponseEntity<String> borrarEmpresa(@PathVariable long id){
		try {
			repoEmp.delete(id);
			return new ReponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ReponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value =" /{id}", method= RequestMethod.Delete)
	public ReponseEntity<String> borraroferta(@PathVariable long id){
		try {
			ofertaRepo.delete(id);
			return new ReponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ReponseEntity<String>(HttpStatus.BAD_REQUEST);
>>>>>>> 89adaa286c8672b5b9c04ba1eb960eb48ef93b6c
		}
	}
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Empresa buscarEmpresa(@PathVariable Long id)
	{
		Empresa empr =repoEmp.findOne(id);
		return empr;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Empresa.class, empreprop);
	}
	
	
}
