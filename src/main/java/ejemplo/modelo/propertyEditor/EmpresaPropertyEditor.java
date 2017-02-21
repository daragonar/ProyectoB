package ejemplo.modelo.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.modelo.entidad.Empresa;
import ejemplo.modelo.repositorio.RepositorioEmpresa;

@Component
public class EmpresaPropertyEditor extends PropertyEditorSupport{

	@Autowired private RepositorioEmpresa empresaRepo;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idEmpresa = Long.parseLong(text);
		Empresa empresa = empresaRepo.findOne(idEmpresa);
		setValue(empresa);
	}
}
