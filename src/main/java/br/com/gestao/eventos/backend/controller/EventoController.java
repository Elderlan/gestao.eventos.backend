package br.com.gestao.eventos.backend.controller;

import br.com.gestao.eventos.backend.dto.EventoEntradaDto;
import br.com.gestao.eventos.backend.dto.EventoSaidaDto;
import br.com.gestao.eventos.backend.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<EventoSaidaDto> atualizarEvento(
            @PathVariable Long id,
            @RequestBody @Valid EventoEntradaDto eventoEntradaDto) {

        EventoSaidaDto eventoAtualizado = eventoService.atualizarEvento(id, eventoEntradaDto);
        return ResponseEntity.ok(eventoAtualizado);
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity<EventoSaidaDto> obterEventoPorId(@PathVariable Long id) {
        EventoSaidaDto evento = eventoService.obterEventoPorId(id);
        return ResponseEntity.ok(evento);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<EventoSaidaDto>> listarEventos(Pageable pageable) {
        Page<EventoSaidaDto> eventos = eventoService.listarEventos(pageable);
        return ResponseEntity.ok(eventos);
    }


}
