package ejemplo.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejemplo.modelo.entidad.Idioma;

@Repository
public interface RepositorioIdioma extends JpaRepository<Idioma, Long>{

}
