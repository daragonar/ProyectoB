package ejemplo.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejemplo.modelo.entidad.Candidato;

@Repository
public interface RepositorioCandidato extends JpaRepository<Candidato, Long> {
}
