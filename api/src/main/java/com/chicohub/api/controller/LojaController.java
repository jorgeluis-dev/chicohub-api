package com.chicohub.api.controller;

import com.chicohub.api.domain.Loja;
import com.chicohub.api.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lojas")
public class LojaController {

    @Autowired
    private LojaRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loja cadastrar(@RequestBody Loja loja) {
        // Recebe o JSON da requisição e salva direto no banco
        return repository.save(loja);
    }
}
