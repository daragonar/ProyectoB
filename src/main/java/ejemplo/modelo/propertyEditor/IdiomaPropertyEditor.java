package ejemplo.modelo.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.modelo.entidad.Idioma;
import ejemplo.modelo.repositorio.RepositorioIdioma;

@Component
public class IdiomaPropertyEditor extends PropertyEditorSupport {

	@Autowired
	RepositorioIdioma repoId;
	
	@Override
	public void setAsText(String text){
		long idIdioma = Long.parseLong(text);
		Idioma idioma= repoId.findOne(idIdioma);
		setValue(idioma);
	}
	
	
}
