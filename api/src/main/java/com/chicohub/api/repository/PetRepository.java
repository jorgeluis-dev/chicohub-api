package com.chicohub.api.repository;

import com.chicohub.api.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    // Busca todos os pets que pertencem a uma loja específica pelo ID dela
    List<Pet> findByLojaId(Long lojaId);
    List<Pet> findByDonoEmail(String email);
}
