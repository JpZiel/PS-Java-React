package br.com.banco.integration.datastore.repository;

import br.com.banco.integration.datastore.entity.TransferenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransferenciaRepository extends JpaRepository<TransferenciaEntity, Long> {
    List<TransferenciaEntity> findByContaId(Long idConta);
    List<TransferenciaEntity> findByContaIdAndNomeOperadorTransacao(Long idConta, String nomeOperador);
    List<TransferenciaEntity> findByContaIdAndNomeOperadorTransacaoAndDataTransferenciaBetween(Long idConta, String nomeOperador, LocalDateTime dataInicio, LocalDateTime dataFim);
    List<TransferenciaEntity> findByContaIdAndDataTransferenciaBetween(Long idConta, LocalDateTime dataInicio, LocalDateTime dataFim);
}
