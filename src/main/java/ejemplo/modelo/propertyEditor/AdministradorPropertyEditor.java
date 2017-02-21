package ejemplo.modelo.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.modelo.entidad.Administrador;
import ejemplo.modelo.repositorio.RepositorioAdministrador;

@Component
public class AdministradorPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private RepositorioAdministrador repoAdmin;

	@Override
	public void setAsText(String text) {
		long idAdmin = Long.parseLong(text);
		Administrador admin = repoAdmin.findOne(idAdmin);
		setValue(admin);
	}

}
