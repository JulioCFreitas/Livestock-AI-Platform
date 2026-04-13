package com.livestock.adapters.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataAnimalRepository extends MongoRepository<AnimalDocument, String> {
}
