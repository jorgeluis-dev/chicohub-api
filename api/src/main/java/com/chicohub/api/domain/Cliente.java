package com.chicohub.api.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    private String telefone;

    @ManyToOne // Muitos clientes pertencem a uma Loja (Unidade)
    @JoinColumn(name = "loja_id", nullable = false)
    private Loja loja;
}