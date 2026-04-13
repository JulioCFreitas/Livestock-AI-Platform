package com.livestock.application.usecase;

import com.livestock.adapters.in.web.dto.AnimalRequest;
import com.livestock.domain.model.Animal;

import java.util.List;

public interface CadastrarAnimalUseCase {

    Animal cadastrar(AnimalRequest request);
    List<Animal> listar();
    Animal buscar(String id);
    Animal atualizar(String id, AnimalRequest request);
    void deletar(String id);
}
