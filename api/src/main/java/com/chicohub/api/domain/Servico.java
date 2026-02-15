package com.chicohub.api.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "servicos")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao; // Ex: Banho e Tosa
    private BigDecimal valor;
    private LocalDate data;

    @ManyToOne // Muitos serviços podem ser feitos no mesmo Pet
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;
}
