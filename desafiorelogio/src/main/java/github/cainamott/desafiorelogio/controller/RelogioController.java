package github.cainamott.desafiorelogio.controller;

import github.cainamott.desafiorelogio.dto.RelogioDTO;
import github.cainamott.desafiorelogio.entity.Relogio;
import github.cainamott.desafiorelogio.service.RelogioService;
import github.cainamott.desafiorelogio.service.RelogioServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
