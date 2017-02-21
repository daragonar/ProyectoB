package ejemplo.modelo.entidad;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Candidato {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCan;
	
	@NotNull
	@NotEmpty
	private String nombre;
	
	@NotNull
	@NotEmpty
	private String apellidos;
	
	@NotNull
	@NotEmpty
	private Date fecha_nac;
	
	@NotNull
	@NotEmpty
	private Boolean genero;
	
	private String imagen;
	
	@NotNull
	@NotEmpty
	private String nif;
	
	@NotNull
	@NotEmpty
	private int movil;
	
	private int movil2;
	
	private int fijo;
	
	private String direccion;
	
	@NotNull
	@NotEmpty
	private String provincia;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Curriculum>curriculum;

	public Long getIdCan() {
		return idCan;
	}

	public void setIdCan(Long idCan) {
		this.idCan = idCan;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public Boolean getGenero() {
		return genero;
	}

	public void setGenero(Boolean genero) {
		this.genero = genero;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public int getMovil() {
		return movil;
	}

	public void setMovil(int movil) {
		this.movil = movil;
	}

	public int getMovil2() {
		return movil2;
	}

	public void setMovil2(int movil2) {
		this.movil2 = movil2;
	}

	public int getFijo() {
		return fijo;
	}

	public void setFijo(int fijo) {
		this.fijo = fijo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Set<Curriculum> getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Set<Curriculum> curriculum) {
		this.curriculum = curriculum;
	}


	
	
	
}
