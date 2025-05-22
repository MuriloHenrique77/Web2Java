package com.example.pratica3.controller;

import jakarta.validation.Valid; // Corrigido: import da anotação @Valid

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.pratica3.model.Veiculo;
import com.example.pratica3.service.VeiculoService;

import org.springframework.http.HttpStatus;

@Controller
@RequestMapping("/veiculos")
public class VeiculoWebController {

    private final VeiculoService veiculoService;

    public VeiculoWebController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    // Mapeia GET /veiculos → redireciona para /veiculos/listar
    @GetMapping
    public String index() {
        return "redirect:/veiculos/listar";
    }

    // 1. Página de cadastro
    @GetMapping("/cadastrar")
    public String exibirFormCadastro(Model model) {
        model.addAttribute("veiculo", new Veiculo());
        return "veiculos/form";
    }

    @PostMapping("/cadastrar")
    public String cadastrarVeiculo(
            @Valid @ModelAttribute("veiculo") Veiculo veiculo, // Corrigido uso de @Valid e classe com V maiúsculo
            BindingResult result,
            RedirectAttributes ra) {

        if (result.hasErrors()) {
            // Corrigido nome da view
            return "veiculos/form";
        }

        veiculoService.salvarVeiculo(veiculo);
        ra.addFlashAttribute("success", "Veículo cadastrado com sucesso!");
        return "redirect:/veiculos/listar";
    }

    // 2. Página de listagem
    @GetMapping("/listar")
    public String listarVeiculos(Model model) {
        model.addAttribute("lista", veiculoService.listarVeiculos());
        return "veiculos/lista";
    }

    // 3. Detalhes e exclusão
    @GetMapping("/{id}")
    public String detalhesVeiculo(@PathVariable Long id, Model model) {
        Veiculo v = veiculoService.buscarPorId(id) // Corrigido: Veiculo com V maiúsculo
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Veículo não encontrado, id: " + id
            ));
        model.addAttribute("veiculo", v);
        return "veiculos/detalhe";
    }

    @PostMapping("/{id}/excluir")
    public String excluirVeiculo(@PathVariable Long id, RedirectAttributes ra) {
        veiculoService.deletarVeiculo(id);
        ra.addFlashAttribute("success", "Veículo excluído com sucesso!");
        return "redirect:/veiculos/listar";
    }
}
