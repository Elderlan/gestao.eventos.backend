package br.com.gestao.eventos.backend.repository;

import br.com.gestao.eventos.backend.model.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


public interface EventoRepository extends CrudRepository<Evento, Long> {

    Page<Evento> findAll(Pageable pageable);
}
