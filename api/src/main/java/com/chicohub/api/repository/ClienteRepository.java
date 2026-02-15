package com.chicohub.api.repository;

import com.chicohub.api.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByLojaId(Long lojaId);
}
