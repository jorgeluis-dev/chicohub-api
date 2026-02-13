package com.chicohub.api.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data // O Lombok cria os getters e setters invisivelmente
@Entity // Avisa o Spring que isso vai virar uma tabela no MySQL
@Table(name = "lojas")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, length = 14, nullable = false)
    private String cnpj;

    private String endereco;
}
