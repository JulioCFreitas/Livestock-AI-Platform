package com.livestock.application.ports;

import com.livestock.adapters.in.web.dto.AnimalResponse;
import com.livestock.domain.model.Animal;
import java.util.List;
import java.util.Optional;

public interface AnimalRepository {

    Animal save(Animal animal);
    boolean existsByIdentificacao(String identificacao);
    List<Animal> findAll();
    Optional<Animal> findById(String id);
    void deleteById(String id);
}
