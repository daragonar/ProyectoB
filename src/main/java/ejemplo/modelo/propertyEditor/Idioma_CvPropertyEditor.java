package ejemplo.modelo.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.modelo.entidad.Idioma_CV;
import ejemplo.modelo.repositorio.RepositorioIdioma_Cv;

@Component
public class Idioma_CvPropertyEditor extends PropertyEditorSupport{
	
	@Autowired
	RepositorioIdioma_Cv repoid_cv;
	
	@Override
	public void setAsText(String text) 
	{
		long idid_cv = Long.parseLong(text);
		Idioma_CV ic= repoid_cv.findOne(idid_cv);
		setValue(ic);
	}

}
