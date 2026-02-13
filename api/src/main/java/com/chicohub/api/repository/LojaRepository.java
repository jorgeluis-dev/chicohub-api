package com.chicohub.api.repository;

import com.chicohub.api.domain.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
    
}
