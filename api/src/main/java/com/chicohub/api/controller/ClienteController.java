package com.chicohub.api.controller;

import com.chicohub.api.domain.Cliente;
import com.chicohub.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
    }

    @GetMapping("/loja/{lojaId}")
    public List<Cliente> listarPorLoja(@PathVariable Long lojaId) {
        return repository.findByLojaId(lojaId);
    }
}
