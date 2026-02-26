package github.cainamott.desafiorelogio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

@Entity
@Table(name = "relogios")
@Data
@RequiredArgsConstructor
public class Relogio {
    @Id
    private UUID id;

    private String marca;
    private String modelo;
    private TipoMovimento tipoMovimento;
    private MaterialCaixa materialCaixa;
    private String referencia;
    private TipoVidro tipoVidro;
    private Integer resistencia;
    private BigInteger precoEmCentavos;
    private Integer diametro;
    private Integer lugToLug;
    private Integer espessura;
    private Integer largura;
    private String urlDaImagem;
    private String etiquetaResistenciaAgua;
    private Integer pontuacaoColecionador;


}
