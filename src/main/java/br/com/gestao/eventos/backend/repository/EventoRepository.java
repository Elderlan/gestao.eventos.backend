package br.com.gestao.eventos.backend.repository;

import br.com.gestao.eventos.backend.model.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.Optional;


public interface EventoRepository extends CrudRepository<Evento, Long> {

    Optional<Evento> findByIdAndAtivoTrue(Long id);

    Page<Evento> findByAtivoTrue(Pageable pageable);
}
