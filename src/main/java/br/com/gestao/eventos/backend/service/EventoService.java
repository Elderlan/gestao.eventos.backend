package br.com.gestao.eventos.backend.service;

import br.com.gestao.eventos.backend.dto.EventoEntradaDto;
import br.com.gestao.eventos.backend.dto.EventoSaidaDto;
import br.com.gestao.eventos.backend.model.Evento;
import br.com.gestao.eventos.backend.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public EventoSaidaDto cadastrarEvento(EventoEntradaDto eventoEntradaDto) {
        Evento evento = new Evento();

        evento.setTitulo(eventoEntradaDto.getTitulo());
        evento.setDescricao(eventoEntradaDto.getDescricao());
        evento.setDataHoraEvento(eventoEntradaDto.getDataHora());
        evento.setLocal(eventoEntradaDto.getLocal());

        Evento eventoSalvo = eventoRepository.save(evento);

        return new EventoSaidaDto(eventoSalvo);
    }
}
