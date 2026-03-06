package github.cainamott.desafiorelogio.mapper;

import github.cainamott.desafiorelogio.dto.CalculaPontuacaoColecionadorDTO;
import github.cainamott.desafiorelogio.dto.RelogioDTO;
import github.cainamott.desafiorelogio.entity.*;
import github.cainamott.desafiorelogio.factory.RelogioFactory;
import org.springframework.stereotype.Component;

@Component
public class RelogioMapper implements RelogioFactory{

    public Relogio mapeiaRelogio(RelogioDTO dto, Relogio relogio){
        if(dto.marca() != null) relogio.setMarca(dto.marca());
        if(dto.modelo() != null) relogio.setModelo(dto.modelo());
        if(dto.diametro() != null) relogio.setDiametro(dto.diametro());
        if(dto.largura() != null) relogio.setLargura(dto.largura());
        if(dto.referencia() != null) relogio.setReferencia(dto.referencia());
        if(dto.tipoMovimento() != null) relogio.setTipoMovimento(dto.tipoMovimento());
        if(dto.materialCaixa() != null) relogio.setMaterialCaixa(dto.materialCaixa());
        if(dto.resistencia() != null) relogio.setResistencia(dto.resistencia());
        if(dto.tipoVidro() != null) relogio.setTipoVidro(dto.tipoVidro());
        if(dto.lugToLug() != null) relogio.setLugToLug(dto.lugToLug());
        if(dto.precoEmCentavos() != null) relogio.setPrecoEmCentavos(dto.precoEmCentavos());
        if(dto.resistencia() != null) relogio.setEtiquetaResistenciaAgua(calculaEtiquetaResistenciaAgua(dto.resistencia()));
        if (dto.tipoVidro() != null && dto.resistencia() != null && dto.materialCaixa() != null && dto.diametro() != null)
                relogio.setPontuacaoColecionador(
                calculaPontuacaoColecionador(
                        dto.tipoVidro(),
                        dto.resistencia(),
                        dto.tipoMovimento(),
                        dto.materialCaixa(),
                        dto.diametro()));
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

    @Override
    public Integer calculaPontuacaoColecionador(
            TipoVidro tipoVidro,
            Integer resistencia,
            TipoMovimento movimento,
            MaterialCaixa materialCaixa,
            Integer diametro
    ) {
        Integer pontuacao = 0;
        if(tipoVidro == TipoVidro.valueOf("SAPPHIRE") ){
            pontuacao += 25;
        }
        if(resistencia >= 200) {
            pontuacao += 25;
        }else if(resistencia >= 100){
            pontuacao += 15;
        }
        if(movimento.equals(TipoMovimento.valueOf("AUTOMATIC"))){
            pontuacao += 20;
        }if(materialCaixa.equals(MaterialCaixa.valueOf("STEEL"))){
            pontuacao += 10;
        }else if(materialCaixa.equals(MaterialCaixa.valueOf("TITANIUM"))){
            pontuacao += 12;
        }
        if(diametro >= 38 && diametro <= 42){
            pontuacao += 8;
        }
        return pontuacao;
    }
}
