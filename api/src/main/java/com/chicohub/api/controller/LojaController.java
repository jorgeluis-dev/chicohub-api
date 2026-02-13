package com.chicohub.api.controller;

import com.chicohub.api.domain.Loja;
import com.chicohub.api.dto.BrasilApiDTO;
import com.chicohub.api.repository.LojaRepository;
import com.chicohub.api.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lojas")
public class LojaController {

    @Autowired
    private LojaRepository repository;

    @Autowired
    private LojaService lojaService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Loja loja) { // Mudamos para ResponseEntity<?> por segurança
        try {
            BrasilApiDTO dadosExternos = lojaService.buscarDadosPorCnpj(loja.getCnpj());

            if (dadosExternos != null && dadosExternos.getRazao_social() != null) {
                loja.setNome(dadosExternos.getRazao_social());
                loja.setEndereco(dadosExternos.getLogradouro() + ", " + dadosExternos.getNumero() +
                        " - " + dadosExternos.getBairro());
            } else {
                // Se não achar os dados, você pode escolher retornar erro ou seguir com o que o
                // usuário mandou
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CNPJ não encontrado ou inválido.");
            }

            Loja novaLoja = repository.save(loja);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaLoja);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar cadastro: " + e.getMessage());
        }
    }
}
