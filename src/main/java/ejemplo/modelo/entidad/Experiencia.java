package ejemplo.modelo.entidad;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.xml.soap.Text;

import org.hibernate.validator.constraints.NotEmpty;

import javassist.expr.NewArray;

@Entity
public class Experiencia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	private Text descripcion;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Curriculum> curriculum = new HashSet<Curriculum>();
	
	

}
