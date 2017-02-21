package ejemplo.modelo.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.modelo.entidad.Rol;
import ejemplo.modelo.repositorio.RepositorioRol;

@Component
public class RolPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private RepositorioRol repoRol;

	@Override
	public void setAsText(String text) {
		long idRol = Long.parseLong(text);
		Rol rol = repoRol.findOne(idRol);
		setValue(rol);
	}

}