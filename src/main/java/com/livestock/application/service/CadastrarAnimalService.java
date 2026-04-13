package com.livestock.application.service;

import com.livestock.application.ports.AnimalRepository;
import com.livestock.application.usecase.CadastrarAnimalCommand;
import com.livestock.application.usecase.CadastrarAnimalUseCase;
import com.livestock.domain.model.Animal;

import java.util.UUID;

public class CadastrarAnimalService implements CadastrarAnimalUseCase {

    private final AnimalRepository repository;

    public CadastrarAnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executar(CadastrarAnimalCommand command) {
        Animal animal = new Animal(
                UUID.randomUUID(),
                command.identificacao(),
                command.tipo(),
                command.raca(),
                command.peso(),
                command.dataNascimento()
        );

        repository.salvar(animal);
    }
}
