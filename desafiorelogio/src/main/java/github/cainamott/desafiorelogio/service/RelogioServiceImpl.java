package github.cainamott.desafiorelogio.service;

import github.cainamott.desafiorelogio.dto.RelogioDTO;
import github.cainamott.desafiorelogio.entity.Relogio;
import github.cainamott.desafiorelogio.mapper.RelogioMapper;
import github.cainamott.desafiorelogio.repository.RelogioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RelogioServiceImpl implements RelogioService {

    private RelogioRepository repository;
    private RelogioMapper mapper;

    public RelogioServiceImpl(RelogioRepository repository) {
        this.repository = repository;
    }

    public Relogio criaRelogio(RelogioDTO dto){
        Relogio relogio = mapper.mapeiaRelogio(dto);
        relogio.setId(UUID.randomUUID());
        return repository.save(relogio);
    }

    @Override
    public void atualizaRelogio(RelogioDTO dto) {

    }

    @Override
    public void deletaRelogio(UUID id) {

    }

    @Override
    public Relogio buscaRelogioPorId(UUID id) {
        return repository.findById(id).orElseThrow();

    }

    @Override
    public List<Relogio> listaRelogiosPorFiltro() {
        return List.of();
    }
}
