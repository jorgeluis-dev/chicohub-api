package com.chicohub.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BrasilApiDTO {
    @JsonProperty("razao_social")
    private String razao_social;
    
    private String logradouro;
    private String numero;
    private String bairro;
    private String municipio;
    private String uf;
    private String cep;
}
