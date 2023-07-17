package br.com.banco.core.usecase;

import br.com.banco.application.dto.response.TransferenciaResponse;
import br.com.banco.core.exception.RecursoNaoEncontradoException;
import br.com.banco.core.mapper.TransferenciaMapper;
import br.com.banco.core.port.transferencia.TransferenciaInbound;
import br.com.banco.core.port.transferencia.TransferenciaOutbound;
import br.com.banco.integration.datastore.entity.TransferenciaEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static br.com.banco.core.mapper.TransferenciaMapper.toResponse;

@Service
@Slf4j
public class TransferenciaUseCase implements TransferenciaInbound {

    private TransferenciaOutbound transferenciaOutbound;

    public TransferenciaUseCase(TransferenciaOutbound transferenciaOutbound) {
        this.transferenciaOutbound = transferenciaOutbound;
    }

    @Override
    public List<TransferenciaResponse> buscar(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim, String nomeOperador) {

        List<TransferenciaEntity> transferencias = null;

        if(Objects.nonNull(dataInicio) && Objects.nonNull(dataFim) && Objects.isNull(nomeOperador)) {
            transferencias = transferenciaOutbound.findByData(idConta, dataInicio, dataFim);
        } else if (Objects.isNull(dataInicio) && Objects.isNull(dataFim) && Objects.nonNull(nomeOperador)){
            transferencias = transferenciaOutbound.findByOperador(idConta, nomeOperador);
        } else if (Objects.nonNull(dataInicio) && Objects.nonNull(dataFim) && Objects.nonNull(nomeOperador)){
            transferencias = transferenciaOutbound.findByOperadorAndData(idConta, nomeOperador, dataInicio, dataFim);
        } else {
            transferencias = transferenciaOutbound.findByIdConta(idConta);
        }

        if(Objects.isNull(transferencias)) throw new RecursoNaoEncontradoException("Não existe transferencia para essa conta");

        return transferencias
                .stream()
                .map(transferenciaEntity -> toResponse(transferenciaEntity))
                .collect(Collectors.toList());
    }
}
