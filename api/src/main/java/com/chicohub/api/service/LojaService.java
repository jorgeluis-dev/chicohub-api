package com.chicohub.api.service;

import com.chicohub.api.dto.BrasilApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LojaService {

    @Autowired
    private RestTemplate restTemplate;

    public BrasilApiDTO buscarDadosPorCnpj(String cnpj) {
        // Remove pontos e traços caso o usuário envie formatado
        String cnpjLimpo = cnpj.replaceAll("\\D", "");
        String url = "https://brasilapi.com.br/api/cnpj/v1/" + cnpjLimpo;

        try {
            return restTemplate.getForObject(url, BrasilApiDTO.class);
        } catch (Exception e) {
            // Se o CNPJ não for encontrado ou a API cair, retorna nulo por enquanto
            return null;
        }
    }
}
