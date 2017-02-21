package ejemplo.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejemplo.modelo.entidad.Rol;



@Repository
public interface RepositorioRol extends JpaRepository<Rol, Long> {

}
