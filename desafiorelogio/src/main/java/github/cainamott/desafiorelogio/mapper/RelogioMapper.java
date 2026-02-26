package github.cainamott.desafiorelogio.mapper;

import github.cainamott.desafiorelogio.dto.RelogioDTO;
import github.cainamott.desafiorelogio.entity.MaterialCaixa;
import github.cainamott.desafiorelogio.entity.Relogio;
import github.cainamott.desafiorelogio.entity.TipoMovimento;
import github.cainamott.desafiorelogio.entity.TipoVidro;

public class RelogioMapper {

    public Relogio mapeiaRelogio(RelogioDTO dto){
        Relogio relogio = new Relogio();
        relogio.setMarca(dto.marca());
        relogio.setModelo(dto.modelo());
        relogio.setDiametro(dto.diametro());
        relogio.setLargura(dto.largura());
        relogio.setReferencia(dto.referencia());
        relogio.setTipoMovimento(dto.tipoMovimento());
        relogio.setMaterialCaixa(dto.materialCaixa());
        relogio.setResistencia(dto.resistencia());
        relogio.setTipoVidro(dto.tipoVidro());
        relogio.setLugToLug(dto.lugToLug());
        relogio.setPrecoEmCentavos(dto.precoEmCentavos());
        relogio.setEtiquetaResistenciaAgua(calculaEtiquetaResistenciaAgua(dto.resistencia()));
        relogio.setPontuacaoColecionador(calculaPontuacaoColecionador(dto.tipoVidro(), dto.resistencia(), dto.tipoMovimento(), dto.materialCaixa(), dto.diametro()));
        relogio.setUrlDaImagem(dto.urlDaImagem());
        return relogio;
    }

    public String calculaEtiquetaResistenciaAgua(Integer resistencia){
        if(resistencia < 50){
            return "respingos";
        }else if(resistencia >= 50 && resistencia < 100){
            return "uso_diario";
        }else if(resistencia >= 100 && resistencia < 200){
            return "natacao";
        }else if(resistencia >= 200){
            return "mergulho";
        }
        return null;
    }

    public Integer calculaPontuacaoColecionador(
            TipoVidro tipoVidro,
            Integer resistencia,
            TipoMovimento movimento,
            MaterialCaixa materialCaixa,
            Integer diametro){

        return null;
    }

}
