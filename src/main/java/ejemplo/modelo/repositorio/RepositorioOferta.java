package ejemplo.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ejemplo.modelo.entidad.Oferta;

@Repository
public interface RepositorioOferta extends JpaRepository<Oferta, Long> {

	Iterable<Oferta> findByTituloIgnoreCaseContaining(String buscar);

}

