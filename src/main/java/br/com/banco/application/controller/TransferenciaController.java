package br.com.banco.application.controller;

import br.com.banco.application.dto.response.TransferenciaResponse;
import br.com.banco.core.exception.ServicoException;
import br.com.banco.core.port.transferencia.TransferenciaInbound;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/transferencias")
@AllArgsConstructor
public class TransferenciaController {

    private final TransferenciaInbound transferenciaInbound;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<TransferenciaResponse>> buscar(
            @RequestParam(value = "id_conta") Long idConta,
            @RequestParam(value = "data_inicio", required = false) String dataInicio,
            @RequestParam(value = "data_fim", required = false) String dataFim,
            @RequestParam(value = "nome_operador", required = false) String nomeOperador) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dataInicioConvertida = null;
        LocalDateTime dataFimConvertida = null;

        try {
            if (Objects.nonNull(dataInicio)) {
                dataInicioConvertida = LocalDateTime.parse(dataInicio, formatter);
            }
            if (Objects.nonNull(dataFim)) {
                dataFimConvertida = LocalDateTime.parse(dataFim, formatter);
            }
        } catch (Exception ex) {
            throw new ServicoException("Ocorreu um erro ao tentar converter a data.");
        }

        var transferencias = transferenciaInbound.buscar(idConta, dataInicioConvertida, dataFimConvertida,
                nomeOperador);

        return ResponseEntity.ok(transferencias);
    }
}
