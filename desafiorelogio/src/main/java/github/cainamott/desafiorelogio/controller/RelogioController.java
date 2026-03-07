package github.cainamott.desafiorelogio.controller;

import github.cainamott.desafiorelogio.dto.AtualizaRelogioDTO;
import github.cainamott.desafiorelogio.dto.CriaRelogioDTO;
import github.cainamott.desafiorelogio.dto.PaginaRelogioDTO;
import github.cainamott.desafiorelogio.dto.RelogioDTO;
import github.cainamott.desafiorelogio.entity.Relogio;
import github.cainamott.desafiorelogio.service.RelogioService;
import github.cainamott.desafiorelogio.service.RelogioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/relogios")
public class RelogioController {

    public RelogioServiceImpl service;

    public RelogioController(RelogioServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RelogioDTO> criarRelogio(@RequestBody CriaRelogioDTO entity){
        return ResponseEntity.ok(service.criaRelogio(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelogioDTO> atualizaRelogio(
            @PathVariable UUID id,
            @RequestBody AtualizaRelogioDTO dto){
        return ResponseEntity.ok(service.atualizaRelogio(id, dto));
    }

    @GetMapping
    public PaginaRelogioDTO listaRelogios(
            @RequestParam(defaultValue = "1") Integer pagina,
            @RequestParam(defaultValue = "12") Integer porPagina,
            @RequestParam(required = false) String busca,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) String referencia,
            @RequestParam(required = false) String tipoMovimento,
            @RequestParam(required = false) String materialCaixa,
            @RequestParam(required = false) String tipoVidro,
            @RequestParam(required = false) Integer resistenciaMin,
            @RequestParam(required = false) Integer resistenciaMax,
            @RequestParam(required = false) Integer precoMin,
            @RequestParam(required = false) Integer precoMax,
            @RequestParam(required = false) Integer diametroMin,
            @RequestParam(required = false) Integer diametroMax,
            @RequestParam(required = false) String ordenar
    ){
        return service.listaRelogios(
                pagina,
                porPagina,
                busca,
                marca,
                modelo,
                referencia,
                tipoMovimento,
                materialCaixa,
                tipoVidro,
                resistenciaMin,
                resistenciaMax,
                precoMin,
                precoMax,
                diametroMin,
                diametroMax,
                ordenar
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<RelogioDTO> buscarPorId(UUID id){
        return ResponseEntity.ok(service.buscaRelogioPorId(id));
    }
}
