package com.chicohub.api.controller;

import com.chicohub.api.domain.Pet;
import com.chicohub.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetRepository repository;

    @PostMapping
    public ResponseEntity<Pet> cadastrar(@RequestBody Pet pet) {
        Pet novoPet = repository.save(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPet);
    }

    @GetMapping("/loja/{lojaId}")
    public List<Pet> listarPorLoja(@PathVariable Long lojaId) {
        return repository.findByLojaId(lojaId);
    }

    // Test-Auth-Google- QUEMSOUEU
    @GetMapping("/quem-sou-eu")
    public String quemSouEu(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            return "Nenhum usuário logado.";
        }
        String nome = principal.getAttribute("name");
        String email = principal.getAttribute("email");
        return "Olá, " + nome + "! Seu e-mail cadastrado no Google é: " + email;
    }
}