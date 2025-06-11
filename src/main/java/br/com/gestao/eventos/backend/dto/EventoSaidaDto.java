package br.com.gestao.eventos.backend.dto;

import br.com.gestao.eventos.backend.model.Evento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoSaidaDto {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHora;
    private String local;

    public EventoSaidaDto(Evento evento) {
        this.id =  evento.getId();
        this.titulo =  evento.getTitulo();
        this.descricao =   evento.getDescricao();
        this.dataHora = evento.getDataHoraEvento();
        this.local = evento.getLocal();
    }
}
