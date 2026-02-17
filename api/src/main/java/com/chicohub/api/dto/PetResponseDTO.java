package com.chicohub.api.dto;

public record PetResponseDTO(
    Long id,
    String nome,
    String especie,
    String raca,
    String donoEmail
) {}
