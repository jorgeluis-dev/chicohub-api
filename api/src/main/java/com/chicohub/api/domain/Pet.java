package com.chicohub.api.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especie; // Ex: Cachorro, Gato
    private String raca;
    private String donoEmail;

    @ManyToOne // Muitos pets pertencem a UMA loja
    @JoinColumn(name = "loja_id", nullable = false)
    private Loja loja;

    @ManyToOne // Muitos Pets pertencem a um cliente
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // O "Getter" para ler o e-mail
    public String getDonoEmail() {
        return donoEmail;
    }

    // O "Setter" para gravar o e-mail
    public void setDonoEmail(String donoEmail) {
        this.donoEmail = donoEmail;
    }
}
