package com.livestock.application.service;

import com.livestock.adapters.in.web.dto.AnimalRequest;
import com.livestock.adapters.in.web.dto.AnimalResponse;
import com.livestock.adapters.out.kafka.AnimalEventProducer;
import com.livestock.adapters.out.mapper.AnimalMapper;
import com.livestock.application.ports.AnimalRepository;
import com.livestock.application.usecase.CadastrarAnimalUseCase;
import com.livestock.domain.event.AnimalCadastradoEvent;
import com.livestock.domain.model.Animal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastrarAnimalService implements CadastrarAnimalUseCase {

    private final AnimalRepository repository;
    private final AnimalMapper mapper;
    private final AnimalEventProducer animalEventProducer;


    public CadastrarAnimalService(AnimalRepository repository, AnimalMapper mapper
    , AnimalEventProducer animalEventProducer) {
        this.repository = repository;
        this.mapper = mapper;
        this.animalEventProducer = animalEventProducer;
    }

    @Override
    public AnimalResponse cadastrar(AnimalRequest request) {

        if (repository.existsByIdentificacao(request.identificacao())) {
            throw new RuntimeException("Animal já existe");
        }

        Animal animal = mapper.toDomainFromRequest(request);
        Animal animalSalvo = repository.save(animal);

        animalEventProducer.enviarEvento(
                new AnimalCadastradoEvent(
                        animalSalvo.getId(),
                        animalSalvo.getIdentificacao(),
                        animalSalvo.getTipo(),
                        animal.getPeso(),
                        animal.getDataNascimento()
                )
        );

        return mapper.toResponse(animalSalvo);
    }

    @Override
    public List<AnimalResponse> listar() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public AnimalResponse buscar(String id) {

        Animal animal = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado para busca."));

        return mapper.toResponse(animal);
    }

    @Override
    public AnimalResponse atualizar(String id, AnimalRequest request) {

        Animal existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado para atualizar."));

        mapper.updateAnimalFromRequest(request, existente);

        Animal animalAtualizado = repository.save(existente);

        return mapper.toResponse(animalAtualizado);
    }

    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }
}

