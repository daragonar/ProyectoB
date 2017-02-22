package ejemplo.modelo.entidad;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Oferta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Empresa empresa;
    
    //@ManyToOne
    //private Test test;
    //Estos dos de arriba serian para: ID_EMPRESA y ID_TEST
   
    @ManyToMany
    private Set<Curriculum> curriculums;
    
    
    public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}



	@NotNull
    @NotEmpty
    private String titulo;
    
    private String tipo_oferta;
    
    private String categoria;
    
    @Column(columnDefinition="LONGTEXT")
    private String requisitos;
    
    @NotNull
    @NotEmpty
    @Column(columnDefinition="LONGTEXT")
    private String descripcion;
    
    @NotNull
    @NotEmpty
    private String localidad;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=ISO.DATE)
    private Date fecha_creacion;
    
    private String sector;
    
    private Integer num_vacantes;
    
    private String nivel;
    
    @NotNull
    @NotEmpty
    private Double salario_min;
    
    @NotNull
    @NotEmpty
    private Double salario_max;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo_oferta() {
        return tipo_oferta;
    }

    public void setTipo_oferta(String tipo_oferta) {
        this.tipo_oferta = tipo_oferta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Integer getNum_vacantes() {
        return num_vacantes;
    }

    public void setNum_vacantes(Integer num_vacantes) {
        this.num_vacantes = num_vacantes;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Double getSalario_min() {
        return salario_min;
    }

    public void setSalario_min(Double salario_min) {
        this.salario_min = salario_min;
    }

    public Double getSalario_max() {
        return salario_max;
    }

    public void setSalario_max(Double salario_max) {
        this.salario_max = salario_max;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((curriculums == null) ? 0 : curriculums.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((fecha_creacion == null) ? 0 : fecha_creacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((num_vacantes == null) ? 0 : num_vacantes.hashCode());
		result = prime * result + ((requisitos == null) ? 0 : requisitos.hashCode());
		result = prime * result + ((salario_max == null) ? 0 : salario_max.hashCode());
		result = prime * result + ((salario_min == null) ? 0 : salario_min.hashCode());
		result = prime * result + ((sector == null) ? 0 : sector.hashCode());
		result = prime * result + ((tipo_oferta == null) ? 0 : tipo_oferta.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Oferta other = (Oferta) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (curriculums == null) {
			if (other.curriculums != null)
				return false;
		} else if (!curriculums.equals(other.curriculums))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (fecha_creacion == null) {
			if (other.fecha_creacion != null)
				return false;
		} else if (!fecha_creacion.equals(other.fecha_creacion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (num_vacantes == null) {
			if (other.num_vacantes != null)
				return false;
		} else if (!num_vacantes.equals(other.num_vacantes))
			return false;
		if (requisitos == null) {
			if (other.requisitos != null)
				return false;
		} else if (!requisitos.equals(other.requisitos))
			return false;
		if (salario_max == null) {
			if (other.salario_max != null)
				return false;
		} else if (!salario_max.equals(other.salario_max))
			return false;
		if (salario_min == null) {
			if (other.salario_min != null)
				return false;
		} else if (!salario_min.equals(other.salario_min))
			return false;
		if (sector == null) {
			if (other.sector != null)
				return false;
		} else if (!sector.equals(other.sector))
			return false;
		if (tipo_oferta == null) {
			if (other.tipo_oferta != null)
				return false;
		} else if (!tipo_oferta.equals(other.tipo_oferta))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	public Set<Curriculum> getCurriculums() {
		return curriculums;
	}

	public void setCurriculums(Set<Curriculum> curriculums) {
		this.curriculums = curriculums;
	}

}