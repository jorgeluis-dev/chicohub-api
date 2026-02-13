package com.chicohub.api.repository;

import com.chicohub.api.domain.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
    // O Spring Data JPA cria a lógica sozinho só pelo nome do método!
    boolean existsByCnpj(String cnpj);    
}
