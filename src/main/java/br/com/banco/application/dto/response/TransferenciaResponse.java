package br.com.banco.application.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferenciaResponse {

    private Long id;

    private LocalDateTime dataTransferencia;

    private BigDecimal valor;

    private String tipo;

    private String nomeOperadorTransacao;
}
