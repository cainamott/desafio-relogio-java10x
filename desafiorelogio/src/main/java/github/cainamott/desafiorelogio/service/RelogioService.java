package github.cainamott.desafiorelogio.service;

import github.cainamott.desafiorelogio.dto.AtualizaRelogioDTO;
import github.cainamott.desafiorelogio.dto.CriaRelogioDTO;
import github.cainamott.desafiorelogio.dto.PaginaRelogioDTO;
import github.cainamott.desafiorelogio.dto.RelogioDTO;
import github.cainamott.desafiorelogio.entity.Relogio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface RelogioService {

    public RelogioDTO criaRelogio(CriaRelogioDTO criaRelogioDTO);

    public RelogioDTO atualizaRelogio(UUID id, AtualizaRelogioDTO atualizaRelogioDTO);

    public void deletaRelogio(UUID id);

    public RelogioDTO buscaRelogioPorId(UUID id);

    public PaginaRelogioDTO listaRelogios(
            Integer pagina,
            Integer porPagina,
            String busca,
            String marca,
            String modelo,
            String referencia,
            String tipoMovimento,
            String materialCaixa,
            String tipoVidro,
            Integer resistenciaMin,
            Integer resistenciaMax,
            Integer precoMin,
            Integer precoMax,
            Integer diametroMin,
            Integer diametroMax,
            String ordenar
    );

}
