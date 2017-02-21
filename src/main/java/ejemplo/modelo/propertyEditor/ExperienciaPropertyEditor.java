package ejemplo.modelo.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.modelo.entidad.Experiencia;
import ejemplo.modelo.repositorio.RepositorioExperiencia;


@Component
public class ExperienciaPropertyEditor extends PropertyEditorSupport{

	@Autowired
	private RepositorioExperiencia repoex;
	
	@Override
	public void setAsText(String text) 
	{
		long idex = Long.parseLong(text);
		Experiencia ex= repoex.findOne(idex);
		setValue(ex);
	}
}
