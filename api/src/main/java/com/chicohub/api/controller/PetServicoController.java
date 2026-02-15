package com.chicohub.api.controller;

import com.chicohub.api.domain.Servico;
import com.chicohub.api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class PetServicoController {

    @Autowired
    private ServicoRepository repository;

    @PostMapping
    public ResponseEntity<Servico> registrar(@RequestBody Servico servico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(servico));
    }

    @GetMapping("/pet/{petId}")
    public List<Servico> listarPorPet(@PathVariable Long petId) {
        return repository.findByPetId(petId);
    }
}
