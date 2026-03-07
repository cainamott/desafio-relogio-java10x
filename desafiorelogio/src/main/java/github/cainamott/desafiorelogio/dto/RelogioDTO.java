package github.cainamott.desafiorelogio.dto;

import lombok.Builder;

import java.math.BigInteger;
import java.util.UUID;

@Builder
public record RelogioDTO(
        UUID id,
        String marca,
        String modelo,
        String tipoMovimento,
        String materialCaixa,
        String referencia,
        String tipoVidro,
        Integer resistencia,
        BigInteger precoEmCentavos,
        Integer diametro,
        Integer lugToLug,
        Integer espessura,
        Integer largura,
        String urlDaImagem,
        String etiquetaResistenciaAgua,
        String pontuacaoColecionador
        ) {
}
