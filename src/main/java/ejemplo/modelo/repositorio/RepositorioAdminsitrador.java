package ejemplo.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejemplo.modelo.entidad.Administrador;

@Repository
public interface RepositorioAdminsitrador extends JpaRepository<Administrador, Long>{

}
