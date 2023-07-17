package br.com.banco.core.port.transferencia;

import br.com.banco.application.dto.request.TransferenciaRequest;
import br.com.banco.application.dto.response.TransferenciaResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaInbound {

    List<TransferenciaResponse> buscar(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim, String nomeOperador);
}
