package ejemplo.modelo.propertyEditor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ejemplo.modelo.entidad.Oferta;
import ejemplo.modelo.repositorio.RepositorioOferta;


@Component
public class OfertaPropertyEditor extends PropertyEditorSupport{

	@Autowired private RepositorioOferta ofertaRepo;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idOferta = Long.parseLong(text);
		Oferta oferta = ofertaRepo.findOne(idOferta);
		setValue(oferta);
	}
}
