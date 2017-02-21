package ejemplo.modelo.entidad;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Curriculum {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @NotEmpty
    private String nombre;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private Candidato candidato;
    
    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Oferta> oferta;
    
    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Experiencia> experiencia;
    
    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Formacion> formacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Set<Oferta> getOferta() {
		return oferta;
	}

	public void setOferta(Set<Oferta> oferta) {
		this.oferta = oferta;
	}

	public Set<Experiencia> getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Set<Experiencia> experiencia) {
		this.experiencia = experiencia;
	}

	public Set<Formacion> getFormacion() {
		return formacion;
	}

	public void setFormacion(Set<Formacion> formacion) {
		this.formacion = formacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formacion == null) ? 0 : formacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((oferta == null) ? 0 : oferta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curriculum other = (Curriculum) obj;
		if (formacion == null) {
			if (other.formacion != null)
				return false;
		} else if (!formacion.equals(other.formacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (oferta == null) {
			if (other.oferta != null)
				return false;
		} else if (!oferta.equals(other.oferta))
			return false;
		return true;
	}
     
    
}