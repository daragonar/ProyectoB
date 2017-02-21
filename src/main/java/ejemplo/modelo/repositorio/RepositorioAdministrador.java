package ejemplo.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejemplo.modelo.entidad.Administrador;

@Repository
public interface RepositorioAdministrador extends JpaRepository<Administrador, Long>{

}
