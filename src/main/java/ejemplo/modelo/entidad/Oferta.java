package ejemplo.modelo.entidad;

import java.util.Date;

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
    
    @ManyToMany
    private Empresa empresa;
    
    //@ManyToOne
    //private Test test;
    //Estos dos de arriba serian para: ID_EMPRESA y ID_TEST
   
    
    
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        return true;
    }

}