package github.cainamott.desafiorelogio.service;

import github.cainamott.desafiorelogio.dto.AtualizaRelogioDTO;
import github.cainamott.desafiorelogio.dto.CriaRelogioDTO;
import github.cainamott.desafiorelogio.dto.PaginaRelogioDTO;
import github.cainamott.desafiorelogio.dto.RelogioDTO;
import github.cainamott.desafiorelogio.entity.Relogio;
import github.cainamott.desafiorelogio.entity.enums.MaterialCaixa;
import github.cainamott.desafiorelogio.entity.enums.OrdenacaoRelogio;
import github.cainamott.desafiorelogio.entity.enums.TipoMovimento;
import github.cainamott.desafiorelogio.entity.enums.TipoVidro;
import github.cainamott.desafiorelogio.mapper.RelogioMapper;
import github.cainamott.desafiorelogio.repository.RelogioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import github.cainamott.desafiorelogio.service.RelogioSpecs.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static github.cainamott.desafiorelogio.service.RelogioSpecs.*;

@Service
@RequiredArgsConstructor
public class RelogioServiceImpl implements RelogioService {

    @Autowired
    private RelogioRepository repository;
    @Autowired
    private RelogioMapper mapper;
    @Autowired
    RelogioSpecs specs;



    @Override
    public RelogioDTO criaRelogio(CriaRelogioDTO criaRelogioDTO){
        Relogio relogio = Relogio.builder()
                .id(UUID.randomUUID())
                .marca(criaRelogioDTO.marca())
                .modelo(criaRelogioDTO.modelo())
                .referencia(criaRelogioDTO.referencia())
                .tipoMovimento(TipoMovimento.fromApi(criaRelogioDTO.tipoMovimento()))
                .tipoVidro(TipoVidro.fromApi(criaRelogioDTO.tipoVidro()))
                .materialCaixa(MaterialCaixa.fromApi(criaRelogioDTO.materialCaixa()))
                .resistenciaAgua(criaRelogioDTO.resistencia())
                .precoEmCentavos(criaRelogioDTO.precoEmCentavos())
                .diametro(criaRelogioDTO.diametro())
                .lugToLug(criaRelogioDTO.lugToLug())
                .espessura(criaRelogioDTO.espessura())
                .largura(criaRelogioDTO.largura())
                .urlDaImagem(criaRelogioDTO.urlDaImagem())
                .criadoEm(Instant.now())
                .build();
        return mapper.relogioToDTO(repository.save(relogio));
    }

    @Override
    public RelogioDTO atualizaRelogio(UUID id, AtualizaRelogioDTO atualizaRelogioDTO) {
        Relogio relogio = repository.findById(id).orElseThrow( () -> new EntityNotFoundException("Relógio Não Encontrado"));
        relogio.setMarca(atualizaRelogioDTO.marca());
        relogio.setModelo(atualizaRelogioDTO.modelo());
        relogio.setReferencia(atualizaRelogioDTO.referencia());
        relogio.setTipoVidro(TipoVidro.fromApi(atualizaRelogioDTO.tipoVidro()));
        relogio.setMaterialCaixa(MaterialCaixa.fromApi(atualizaRelogioDTO.materialCaixa()));
        relogio.setTipoMovimento(TipoMovimento.fromApi(atualizaRelogioDTO.tipoMovimento()));
        relogio.setResistenciaAgua(atualizaRelogioDTO.resistencia());
        relogio.setPrecoEmCentavos(atualizaRelogioDTO.precoEmCentavos());
        relogio.setDiametro(atualizaRelogioDTO.diametro());
        relogio.setLugToLug(atualizaRelogioDTO.lugToLug());
        relogio.setEspessura(atualizaRelogioDTO.espessura());
        relogio.setLargura(atualizaRelogioDTO.largura());
        relogio.setUrlDaImagem(atualizaRelogioDTO.urlDaImagem());
        return mapper.relogioToDTO(repository.save(relogio));
    }

    @Override
    public void deletaRelogio(UUID id) {
        Relogio relogio = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Relógio Não Encontrado"));
        repository.delete(relogio);
    }

    @Override
    public RelogioDTO buscaRelogioPorId(UUID id) {
        Relogio relogio = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Relógio Não Encontrado"));
        return mapper.relogioToDTO(relogio);
    }

    @Override
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
            String ordenar) {

        int paginaSegura = Math.max(1, pagina);
        int porPaginaSegura = Math.min(60, Math.max(1, porPagina));

        TipoMovimento movimento = TipoMovimento.fromApi(tipoMovimento);
        MaterialCaixa material =  MaterialCaixa.fromApi(materialCaixa);
        TipoVidro vidro = TipoVidro.fromApi(tipoVidro);

        OrdenacaoRelogio ordenacaoRelogio = OrdenacaoRelogio.fromApi(ordenar);

        Sort sort = switch (ordenacaoRelogio) {
            case MAIS_RECENTES -> Sort.by(Sort.Direction.DESC, "criadoEm");
            case DIAMETRO_CRESC -> Sort.by(Sort.Direction.ASC, "diametro");
            case PRECO_CRESC -> Sort.by(Sort.Direction.ASC, "precoEmCentavos");
            case PRECO_DESC -> Sort.by(Sort.Direction.DESC, "precoEmCentavos");
            case RESISTENCIA_CRESC -> Sort.by(Sort.Direction.ASC, "resistenciaAgua");
        };

        Pageable pageable = PageRequest.of(paginaSegura - 1, porPaginaSegura, sort);

        Specification<Relogio> spec = Specification.where(search(busca))
                .and(marcaIgual(marca))
                .and(modeloIgual(modelo))
                .and(referenciaIgual(referencia))
                .and(tipoMovimento(movimento))
                .and(tipoVidro(vidro))
                .and(materialCaixa(material))
                .and(resistenciaAgua(resistenciaMin, resistenciaMax))
                .and(precoEntre(precoMin, precoMax))
                .and(diametroEntre(diametroMin, diametroMax));

        Page<Relogio> resultado = repository.findAll(spec, pageable);

        return new PaginaRelogioDTO(
                resultado.getContent().stream().map(mapper::relogioToDTO).toList(),
                resultado.getTotalElements()
        );

    }


}
