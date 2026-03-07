package github.cainamott.desafiorelogio.entity;

import github.cainamott.desafiorelogio.entity.enums.MaterialCaixa;
import github.cainamott.desafiorelogio.entity.enums.TipoMovimento;
import github.cainamott.desafiorelogio.entity.enums.TipoVidro;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "relogios", indexes = {
        @Index(name = "IDX_RELOGIO_MARCA", columnList = "marca"),
        @Index(name = "IDX_RELOGIO_CRIADO_EM", columnList = "criadoEm"),
        @Index(name = "IDX_RELOGIO_PRECO", columnList = "precoEmCentavos")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Relogio {
    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, length = 80)
    private String marca;

    @Column(nullable = false, length = 125)
    private String modelo;

    @Column(nullable = false, length = 80)
    private String referencia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoMovimento tipoMovimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private MaterialCaixa materialCaixa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoVidro tipoVidro;

    @Column(nullable = false)
    private Integer resistenciaAgua;

    @Column(nullable = false)
    private BigInteger precoEmCentavos;

    @Column(nullable = false)
    private Integer diametro;

    @Column
    private Integer lugToLug;

    @Column(nullable = false)
    private Integer espessura;

    @Column(nullable = false)
    private Integer largura;

    @Column(nullable = false, length = 600)
    private String urlDaImagem;

    @Column(nullable = false)
    private String etiquetaResistenciaAgua;

    @Column(nullable = false)
    private Integer pontuacaoColecionador;

    @Column(nullable = false)
    private Instant criadoEm;


    @PrePersist
    void prePersist(){
        if(id == null) id = UUID.randomUUID();
        if(criadoEm == null) criadoEm = Instant.now();
        normalize();
    }

    @PreUpdate
    void preUpdate(){
        normalize();
    }

    void normalize(){
        if(marca != null) marca.trim();
        if(modelo != null) modelo.trim();
        if(referencia != null) referencia.trim();
        if(urlDaImagem != null) urlDaImagem.trim();
    }
}
