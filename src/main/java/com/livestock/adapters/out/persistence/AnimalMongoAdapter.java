package com.livestock.adapters.out.persistence;

import com.livestock.adapters.out.mapper.AnimalMapper;
import com.livestock.application.ports.AnimalRepository;
import com.livestock.domain.model.Animal;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AnimalMongoAdapter implements AnimalRepository {

    private final SpringDataAnimalRepository repository;
    private final AnimalMapper mapper;

    public AnimalMongoAdapter(SpringDataAnimalRepository repository, AnimalMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Animal save(Animal animal) {
        AnimalDocument doc = mapper.toDocument(animal);
        return mapper.toDomain(repository.save(doc));
    }

    @Override
    public List<Animal> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Animal> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public boolean existsByIdentificacao(String identificacao) {
        return repository.findByIdentificacao(identificacao).isPresent();
    }
}
