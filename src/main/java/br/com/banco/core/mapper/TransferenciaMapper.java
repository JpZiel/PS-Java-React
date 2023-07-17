package br.com.banco.core.mapper;

import br.com.banco.application.dto.response.TransferenciaResponse;
import br.com.banco.integration.datastore.entity.TransferenciaEntity;

public class TransferenciaMapper {

    public static TransferenciaResponse toResponse(TransferenciaEntity entity){
        return TransferenciaResponse.builder()
                .id(entity.getId())
                .dataTransferencia(entity.getDataTransferencia())
                .nomeOperadorTransacao(entity.getNomeOperadorTransacao())
                .tipo(entity.getTipo())
                .valor(entity.getValor())
                .build();
    }
}
