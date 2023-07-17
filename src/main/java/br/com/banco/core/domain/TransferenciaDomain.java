package br.com.banco.core.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferenciaDomain {

    private Integer id;

    private LocalDateTime dataTransferencia;

    private BigDecimal valor;

    private String tipo;

    private String nomeOperadorTransacao;
}
