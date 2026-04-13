package com.livestock.application.ports;

import com.livestock.domain.model.Animal;

public interface AnimalRepository {
    Animal salvar(Animal animal);
}
