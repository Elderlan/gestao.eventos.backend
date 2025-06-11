package br.com.gestao.eventos.backend.repository;

import br.com.gestao.eventos.backend.model.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, Long> {
}
