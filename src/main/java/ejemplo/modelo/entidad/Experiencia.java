package ejemplo.modelo.entidad;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.soap.Text;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Experiencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEx;

	@NotNull
	@NotEmpty
	private String nomempresa;

	@NotNull
	@NotEmpty
	private String puesto;

	@NotNull
	private Date fecha_inic;

	@NotNull
	private Date fecha_fin;

	
	private String descripcion;

	public Long getIdEx() {
		return idEx;
	}

	public void setIdEx(Long idEx) {
		this.idEx = idEx;
	}

	public String getNomempresa() {
		return nomempresa;
	}

	public void setNomempresa(String nomempresa) {
		this.nomempresa = nomempresa;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Date getFecha_inic() {
		return fecha_inic;
	}

	public void setFecha_inic(Date fecha_inic) {
		this.fecha_inic = fecha_inic;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha_fin == null) ? 0 : fecha_fin.hashCode());
		result = prime * result + ((fecha_inic == null) ? 0 : fecha_inic.hashCode());
		result = prime * result + ((idEx == null) ? 0 : idEx.hashCode());
		result = prime * result + ((nomempresa == null) ? 0 : nomempresa.hashCode());
		result = prime * result + ((puesto == null) ? 0 : puesto.hashCode());
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
		Experiencia other = (Experiencia) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fecha_fin == null) {
			if (other.fecha_fin != null)
				return false;
		} else if (!fecha_fin.equals(other.fecha_fin))
			return false;
		if (fecha_inic == null) {
			if (other.fecha_inic != null)
				return false;
		} else if (!fecha_inic.equals(other.fecha_inic))
			return false;
		if (idEx == null) {
			if (other.idEx != null)
				return false;
		} else if (!idEx.equals(other.idEx))
			return false;
		if (nomempresa == null) {
			if (other.nomempresa != null)
				return false;
		} else if (!nomempresa.equals(other.nomempresa))
			return false;
		if (puesto == null) {
			if (other.puesto != null)
				return false;
		} else if (!puesto.equals(other.puesto))
			return false;
		return true;
	}

}