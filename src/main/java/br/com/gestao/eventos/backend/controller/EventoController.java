package br.com.gestao.eventos.backend.controller;

import br.com.gestao.eventos.backend.dto.EventoEntradaDto;
import br.com.gestao.eventos.backend.dto.EventoSaidaDto;
import br.com.gestao.eventos.backend.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<EventoSaidaDto> cadastrarAnuncio(@RequestBody  @Valid EventoEntradaDto eventoEntradaDto) {
        EventoSaidaDto eventoSaidaDto = this.eventoService.cadastrarEvento(eventoEntradaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoSaidaDto);
    }
}
