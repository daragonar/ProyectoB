package ejemplo.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejemplo.modelo.entidad.Experiencia;

@Repository
public interface RepositorioExperiencia extends JpaRepository<Experiencia, Long> {

}
