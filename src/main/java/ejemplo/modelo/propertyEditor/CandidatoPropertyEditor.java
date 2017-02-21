package ejemplo.modelo.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.modelo.entidad.Candidato;
import ejemplo.modelo.repositorio.RepositorioCandidato;


@Component
public class CandidatoPropertyEditor extends PropertyEditorSupport{

	@Autowired private RepositorioCandidato candidatoRepo;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idCandidato = Long.parseLong(text);
		Candidato candidato = candidatoRepo.findOne(idCandidato);
		setValue(candidato);
	}
}