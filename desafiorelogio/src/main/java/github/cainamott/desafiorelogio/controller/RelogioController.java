package github.cainamott.desafiorelogio.controller;

import github.cainamott.desafiorelogio.dto.RelogioDTO;
import github.cainamott.desafiorelogio.entity.Relogio;
import github.cainamott.desafiorelogio.service.RelogioService;
import github.cainamott.desafiorelogio.service.RelogioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/relogios")
public class RelogioController {

    public RelogioServiceImpl service;

    public RelogioController(RelogioServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Relogio> criarRelogio(@RequestBody RelogioDTO entity){
        return ResponseEntity.ok(service.criaRelogio(entity));
    }

    @PutMapping("{id}")
    public ResponseEntity<Relogio> atualizaRelogio(
            @RequestParam UUID id,
            @RequestBody RelogioDTO dto){
        service.atualizaRelogio(id, dto);
        return ResponseEntity.accepted().build();
    }
}
