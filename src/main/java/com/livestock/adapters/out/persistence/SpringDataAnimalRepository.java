package com.livestock.adapters.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SpringDataAnimalRepository extends MongoRepository<AnimalDocument, String> {
    Optional<AnimalDocument> findByIdentificacao(String identificacao);
}
