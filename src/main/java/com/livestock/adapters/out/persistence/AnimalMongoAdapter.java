package com.livestock.adapters.out.persistence;

import com.livestock.application.ports.AnimalRepository;
import com.livestock.domain.model.Animal;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalMongoAdapter implements AnimalRepository {

    private final SpringDataAnimalRepository repository;

    public AnimalMongoAdapter(SpringDataAnimalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Animal salvar(Animal animal) {
        AnimalDocument doc = new AnimalDocument();
        doc.setId(animal.getId().toString());
        doc.setIdentificacao(animal.getIdentificacao());
        doc.setTipo(animal.getTipo().name());
        doc.setRaca(animal.getRaca());
        doc.setPeso(animal.getPeso());

        repository.save(doc);

        return animal;
    }
}
