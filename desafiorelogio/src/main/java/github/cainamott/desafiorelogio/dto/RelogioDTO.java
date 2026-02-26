package github.cainamott.desafiorelogio.dto;

import github.cainamott.desafiorelogio.entity.MaterialCaixa;
import github.cainamott.desafiorelogio.entity.TipoMovimento;
import github.cainamott.desafiorelogio.entity.TipoVidro;

import java.math.BigInteger;

public record RelogioDTO(
        String marca,
        String modelo,
        TipoMovimento tipoMovimento,
        MaterialCaixa materialCaixa,
        String referencia,
        TipoVidro tipoVidro,
        Integer resistencia,
        BigInteger precoEmCentavos,
        Integer diametro,
        Integer lugToLug,
        Integer espessura,
        Integer largura,
        String urlDaImagem,
        String etiquetaResistenciaAgua,
        Integer pontuacaoColecionador) {
}
