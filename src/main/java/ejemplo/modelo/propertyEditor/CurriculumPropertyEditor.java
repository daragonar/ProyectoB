package ejemplo.modelo.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.modelo.entidad.Curriculum;
import ejemplo.modelo.repositorio.RepositorioCurriculum;


@Component
public class CurriculumPropertyEditor extends PropertyEditorSupport{
	
	@Autowired
	private RepositorioCurriculum repocu;
	
	@Override
	public void setAsText(String text){
		
		long idcv = Long.parseLong(text);
		Curriculum cv= repocu.findOne(idcv);
		setValue(cv);
		
	}

}
