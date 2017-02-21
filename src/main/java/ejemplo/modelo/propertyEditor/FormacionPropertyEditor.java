package ejemplo.modelo.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.modelo.entidad.Formacion;
import ejemplo.modelo.repositorio.RepositorioFormacion;

@Component
public class FormacionPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private RepositorioFormacion repoFor;
	
	@Override
	public void setAsText(String text){
		long idFormacion = Long.parseLong(text);
		Formacion f= repoFor.findOne(idFormacion);
		setValue(f);
	}
}
