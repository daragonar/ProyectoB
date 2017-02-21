package ejemplo.controller;

import javax.validation.Valid;

import org.empleodigital.domain.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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



@Controller
@RequestMapping("/empresa")
public class EmpresaControlador {

	@Autowired
	private EmpresaRepositorio repoEmp;
	@Autowired
	private OfertaRepositorio repoOfer;

	
	@RequestMapping(method = RequestMethod.GET)
	public String listaEmpresa(Model model)
	{
		model.addAttribute("empresas",repoEmp.FindAll())
		return "pages/empresas";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public String detalleEmpresa(Model model, @PathVariable long id)
	{
		model.addAttribute("empresa", repoEmp.findOne(id));
		return "pages/detalleEmpresa";
	}
	
	@RequestMapping(method=RequestMapping.GET,value="/oferta/{id}")
	private String detallesOfertaEmpresa (Model model, @PathVariable long id){
		
		model.addAllAttributes("oferta", repoOfer.findOne(Oferta.id))
		return "page/detalleOfertasEmpresa"

	}
	@RequestMapping(method = RequestMethod.POST)
	public String guardarEmpresa(Model model, @Valid @ModelAttribute Empresa empresa, BindingResult bindingResult)
	{
		empresaRepo.save(empresa);
		model.addAttribute("empresa",repoEmp.findAll());
		return "pages/empresaListado";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String guardarOferta(Model model, @Valid @ModelAttribute Oferta oferta, BindingResult bindingResult)
	{
		oferRepo.save(oferta);
		model.addAttribute("oferta",repoOfer.findAll());
		return "pages/empresaListado";
	}
	
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
