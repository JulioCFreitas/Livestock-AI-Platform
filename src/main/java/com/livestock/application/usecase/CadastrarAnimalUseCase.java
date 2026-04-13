package com.livestock.application.usecase;

import com.livestock.domain.model.Animal;

public interface CadastrarAnimalUseCase {
    Animal executar(CadastrarAnimalCommand command);
}
