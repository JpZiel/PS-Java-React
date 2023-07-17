package br.com.banco.core.port.transferencia;

import br.com.banco.core.domain.TransferenciaDomain;
import br.com.banco.integration.datastore.entity.TransferenciaEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaOutbound {

    List<TransferenciaEntity> findByIdConta(Long idConta);
    List<TransferenciaEntity> findByOperador(Long idConta, String nomeOperador);
    List<TransferenciaEntity> findByOperadorAndData(Long idConta, String nomeOperador, LocalDateTime dataInicio, LocalDateTime dataFim);
    List<TransferenciaEntity> findByData(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim);
}
