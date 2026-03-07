package github.cainamott.desafiorelogio.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigInteger;

public record AtualizaRelogioDTO(
        @NotBlank @Size(max = 80) String marca,
        @NotBlank @Size(max = 80) String modelo,
        @NotBlank @Size(max = 80) String referencia,
        @NotBlank String tipoMovimento,
        @NotBlank String materialCaixa,
        @NotBlank String tipoVidro,

        @Min(0) Integer resistencia,
        @Min(1) BigInteger precoEmCentavos,
        @Min(5) Integer diametro,
        @Min(20) Integer lugToLug,
        @Min(5) Integer espessura,
        @Min(5) Integer largura,
        @NotNull @Size(max = 600) String urlDaImagem
) {
}
