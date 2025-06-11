package br.com.gestao.eventos.backend.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoEntradaDto {

    @NotBlank(message = "O título é obrigatório.")
    @Size(max = 100, message = "O título deve ter no máximo 100 caracteres.")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória.")
    @Size(max = 1000, message = "A descrição deve ter no máximo 1000 caracteres.")
    private String descricao;

    @NotNull(message = "A data e hora do evento são obrigatórias.")
    @FutureOrPresent(message = "A data e hora do evento devem ser no presente ou futuro.")
    private LocalDateTime dataHora;

    @NotBlank(message = "O local é obrigatório.")
    @Size(max = 200, message = "O local deve ter no máximo 200 caracteres.")
    private String local;
}
