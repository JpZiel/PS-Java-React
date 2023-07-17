package br.com.banco.integration.datastore;

import br.com.banco.core.port.transferencia.TransferenciaOutbound;
import br.com.banco.integration.datastore.entity.TransferenciaEntity;
import br.com.banco.integration.datastore.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferenciaPersistence implements TransferenciaOutbound {

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaPersistence(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    @Override
    public List<TransferenciaEntity> findByIdConta(Long idConta) {
        return transferenciaRepository.findByContaId(idConta);
    }

    @Override
    public List<TransferenciaEntity> findByOperador(Long idConta, String nomeOperador) {
        return transferenciaRepository.findByContaIdAndNomeOperadorTransacao(idConta, nomeOperador);
    }

    @Override
    public List<TransferenciaEntity> findByOperadorAndData(Long idConta, String nomeOperador, LocalDateTime dataInicio, LocalDateTime dataFim) {
        return transferenciaRepository.findByContaIdAndNomeOperadorTransacaoAndDataTransferenciaBetween(idConta, nomeOperador, dataInicio, dataFim);
    }

    @Override
    public List<TransferenciaEntity> findByData(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim) {
        return transferenciaRepository.findByContaIdAndDataTransferenciaBetween(idConta, dataInicio, dataFim);
    }
}
