package github.cainamott.desafiorelogio.factory;

import github.cainamott.desafiorelogio.entity.MaterialCaixa;
import github.cainamott.desafiorelogio.entity.TipoMovimento;
import github.cainamott.desafiorelogio.entity.TipoVidro;

public interface RelogioFactory {

    public Integer calculaPontuacaoColecionador(
            TipoVidro vidro,
            Integer resistencia,
            TipoMovimento movimento,
            MaterialCaixa materialCaixa,
            Integer diametro
    );
}
