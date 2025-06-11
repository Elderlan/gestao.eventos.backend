package br.com.gestao.eventos.backend.service;

import br.com.gestao.eventos.backend.dto.EventoEntradaDto;
import br.com.gestao.eventos.backend.dto.EventoSaidaDto;
import br.com.gestao.eventos.backend.model.Evento;
import br.com.gestao.eventos.backend.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

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

    public EventoSaidaDto atualizarEvento(Long id, EventoEntradaDto dto) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado"));

        evento.setTitulo(dto.getTitulo());
        evento.setDescricao(dto.getDescricao());
        evento.setDataHoraEvento(dto.getDataHora());
        evento.setLocal(dto.getLocal());

        Evento atualizado = eventoRepository.save(evento);

        return new EventoSaidaDto(atualizado);
    }

    public EventoSaidaDto obterEventoPorId(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado"));
        return new EventoSaidaDto(evento);
    }

    public Page<EventoSaidaDto> listarEventos(Pageable pageable) {
        return eventoRepository.findAll(pageable)
                .map(this::converterParaDto);
    }

    private EventoSaidaDto converterParaDto(Evento evento) {
        return new EventoSaidaDto(
                evento.getId(),
                evento.getTitulo(),
                evento.getDescricao(),
                evento.getDataHoraEvento(),
                evento.getLocal()
        );
    }


}
