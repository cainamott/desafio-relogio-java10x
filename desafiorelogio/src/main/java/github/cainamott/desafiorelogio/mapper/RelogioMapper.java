package github.cainamott.desafiorelogio.mapper;

import github.cainamott.desafiorelogio.dto.RelogioDTO;
import github.cainamott.desafiorelogio.entity.*;
import github.cainamott.desafiorelogio.entity.enums.MaterialCaixa;
import github.cainamott.desafiorelogio.entity.enums.TipoMovimento;
import github.cainamott.desafiorelogio.entity.enums.TipoVidro;
import org.springframework.stereotype.Component;

@Component
public class RelogioMapper{

    public MaterialCaixa materialCaixa;
    public TipoVidro tipoVidro;
    public TipoMovimento tipoMovimento;

    public RelogioDTO relogioToDTO(Relogio entity){
        return RelogioDTO.builder()
                .id(entity.getId())
                .marca(entity.getMarca())
                .modelo(entity.getModelo())
                .referencia(entity.getReferencia())
                .materialCaixa(entity.getMaterialCaixa().toApi())
                .tipoVidro(entity.getTipoVidro().toApi())
                .tipoMovimento(entity.getTipoMovimento().toApi())
                .diametro(entity.getDiametro())
                .espessura(entity.getEspessura())
                .lugToLug(entity.getLugToLug())
                .largura(entity.getLugToLug())
                .resistencia(entity.getResistenciaAgua())
                .etiquetaResistenciaAgua(entity.getEtiquetaResistenciaAgua())
                .espessura(entity.getEspessura())
                .precoEmCentavos(entity.getPrecoEmCentavos())
                .urlDaImagem(entity.getUrlDaImagem())
                .etiquetaResistenciaAgua(calculaEtiquetaResistenciaAgua(entity.getResistenciaAgua()))
                .pontuacaoColecionador(calculaPontuacaoColecionador(entity).toString())
                .build();
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

    public Integer calculaPontuacaoColecionador(Relogio relogio) {
        Integer pontuacao = 0;
        if(relogio.getTipoVidro() == TipoVidro.SAPPHIRE){
            pontuacao += 25;
        }
        if(relogio.getResistenciaAgua() >= 200) {
            pontuacao += 25;
        }else if(relogio.getResistenciaAgua() >= 100){
            pontuacao += 15;
        }
        if(relogio.getTipoMovimento().equals(TipoMovimento.AUTOMATIC)){
            pontuacao += 20;
        }if(relogio.getMaterialCaixa().equals(MaterialCaixa.STEEL)){
            pontuacao += 10;
        }else if(relogio.getMaterialCaixa().equals(MaterialCaixa.TITANIUM)){
            pontuacao += 12;
        }
        if(relogio.getDiametro() >= 38 && relogio.getDiametro() <= 42){
            pontuacao += 8;
        }
        return pontuacao;
    }
}
