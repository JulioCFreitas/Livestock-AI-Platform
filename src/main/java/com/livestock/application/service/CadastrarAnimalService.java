package com.livestock.application.service;

import com.livestock.adapters.in.web.dto.AnimalRequest;
import com.livestock.adapters.out.mapper.AnimalMapper;
import com.livestock.application.ports.AnimalRepository;
import com.livestock.application.usecase.CadastrarAnimalUseCase;
import com.livestock.domain.model.Animal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastrarAnimalService implements CadastrarAnimalUseCase {

    private final AnimalRepository repository;
    private final AnimalMapper mapper;


    public CadastrarAnimalService(AnimalRepository repository, AnimalMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Animal cadastrar(AnimalRequest request) {

        if (repository.existsByIdentificacao(request.identificacao())) {
            throw new RuntimeException("Animal já existe");
        }

        Animal animal = mapper.toDomainFromRequest(request);

        return repository.save(animal);
    }

    @Override
    public List<Animal> listar() {
        return repository.findAll();
    }

    @Override
    public Animal buscar(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado para busca."));
    }

    @Override
    public Animal atualizar(String id, AnimalRequest request) {

        Animal existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado para atualizar."));

        mapper.updateAnimalFromRequest(request, existente);

        return repository.save(existente);
    }

    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }
}

