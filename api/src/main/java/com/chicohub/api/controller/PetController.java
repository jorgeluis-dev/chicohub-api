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
    public ResponseEntity<Pet> cadastrar(@RequestBody Pet pet, @AuthenticationPrincipal OAuth2User principal) {
        // AuthTestOnly - Forçamos o e-mail do dono que já existe no DBeaver
        String emailLogado = "jorgeluis.geek@gmail.com";
        pet.setDonoEmail(emailLogado);

        // --- ADICIONE ESTAS LINHAS PARA TESTE SE NECESSÁRIO ---
        // Se o seu Pet tem um relacionamento com Loja, precisamos carimbar o ID 1
        // ----------------------------------------

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

    @GetMapping("/meus-pets")
    public List<Pet> listarMeusPets(@AuthenticationPrincipal OAuth2User principal) {
        // 1. Pegamos o e-mail de quem está logado no Google
        // Para testes no Postman, evitamos o NullPointer se o principal for nulo
        String emailLogado = (principal != null) ? principal.getAttribute("email") : "jorgeluis.geek@gmail.com";

        // 2. Buscamos no banco apenas os pets desse e-mail
        return repository.findByDonoEmail(emailLogado);
    }
}