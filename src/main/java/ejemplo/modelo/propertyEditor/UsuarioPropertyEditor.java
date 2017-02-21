package ejemplo.modelo.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.modelo.entidad.Usuario;
import ejemplo.modelo.repositorio.RepositorioUsuario;

@Component
public class UsuarioPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private RepositorioUsuario repoUsu;

	@Override
	public void setAsText(String text) {
		long idUsuario = Long.parseLong(text);
		Usuario usu = repoUsu.findOne(idUsuario);
		setValue(usu);
	}

}