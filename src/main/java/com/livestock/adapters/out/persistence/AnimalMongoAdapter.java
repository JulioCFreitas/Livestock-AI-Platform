package com.livestock.adapters.out.persistence;

import com.livestock.adapters.in.web.dto.AnimalResponse;
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
        AnimalDocument animalDocument = mapper.toDocument(animal);
        AnimalDocument animalSaved =  repository.save(animalDocument);
        return mapper.toDomainFromDocument(animalSaved);
    }

    @Override
    public List<Animal> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomainFromDocument)
                .toList();
    }

    @Override
    public Optional<Animal> findById(String id) {
        return repository.findById(id)
                .map(mapper::toDomainFromDocument);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsByIdentificacao(String identificacao) {
        return repository.findByIdentificacao(identificacao).isPresent();
    }
}