package com.chicohub.api.repository;

import com.chicohub.api.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    List<Servico> findByPetId(Long petId);
}
