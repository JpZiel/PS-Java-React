package br.com.banco.integration.datastore.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "conta")
@AllArgsConstructor
@NoArgsConstructor
public class ContaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name = "nome_responsavel")
    private String nomeResponsavel;

    @OneToMany(mappedBy = "conta")
    @ToString.Exclude
    @JsonManagedReference
    private List<TransferenciaEntity> transferencias;
}
