package com.livestock.application.usecase;

import com.livestock.adapters.in.web.dto.AnimalRequest;
import com.livestock.adapters.in.web.dto.AnimalResponse;
import com.livestock.domain.model.Animal;

import java.util.List;

public interface CadastrarAnimalUseCase {

    AnimalResponse cadastrar(AnimalRequest request);
    List<AnimalResponse> listar();
    AnimalResponse buscar(String id);
    AnimalResponse atualizar(String id, AnimalRequest request);
    void deletar(String id);
}
