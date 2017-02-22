package ejemplo.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejemplo.modelo.entidad.Empresa;


@Repository
public interface RepositorioEmpresa extends JpaRepository<Empresa, Long>{

	Iterable<Empresa> findByNombreIgnoreCaseContaining(String buscar);

}
