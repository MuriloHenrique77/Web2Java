package com.example.pratica3.controller;

import java.util.List;

import jakarta.validation.Valid; // Import necessário para @Valid

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pratica3.service.VeiculoService;
import com.example.pratica3.model.Veiculo;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoService.listarVeiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculo(@PathVariable Long id) {
        return veiculoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Veiculo> criarVeiculo(@Valid @RequestBody Veiculo veiculo) {
        Veiculo criado = veiculoService.salvarVeiculo(veiculo);
        return ResponseEntity.status(201).body(criado); // 201 Created
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        if (veiculoService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
