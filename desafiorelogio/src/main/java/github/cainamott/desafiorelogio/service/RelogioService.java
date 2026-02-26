package github.cainamott.desafiorelogio.service;

import github.cainamott.desafiorelogio.dto.RelogioDTO;
import github.cainamott.desafiorelogio.entity.Relogio;

import java.util.List;
import java.util.UUID;

public interface RelogioService {

    public Relogio criaRelogio(RelogioDTO dto);

    public void atualizaRelogio(UUID id, RelogioDTO dto);

    public void deletaRelogio(UUID id);

    public Relogio buscaRelogioPorId(UUID id);

    public List<Relogio> listaRelogiosPorFiltro();

}
