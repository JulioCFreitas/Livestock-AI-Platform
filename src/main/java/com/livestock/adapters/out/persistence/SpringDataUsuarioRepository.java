package com.livestock.adapters.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SpringDataUsuarioRepository extends MongoRepository<UsuarioDocument, String> {
    Optional<UsuarioDocument> findByEmail(String email);
}
