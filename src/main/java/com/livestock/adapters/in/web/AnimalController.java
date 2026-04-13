package com.livestock.adapters.in.web;

import com.livestock.adapters.in.web.dto.AnimalRequest;
import com.livestock.adapters.in.web.dto.AnimalResponse;
import com.livestock.adapters.out.mapper.AnimalMapper;
import com.livestock.application.usecase.CadastrarAnimalUseCase;
import com.livestock.domain.model.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final CadastrarAnimalUseCase useCase;
    private final AnimalMapper mapper;

    public AnimalController(CadastrarAnimalUseCase useCase, AnimalMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<AnimalResponse> cadastrar(@RequestBody AnimalRequest request) {
        Animal animal = useCase.cadastrar(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(animal));
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponse>> listar() {

        return ResponseEntity.ok(
                useCase.listar()
                        .stream()
                        .map(mapper::toResponse)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponse> buscar(@PathVariable String id) {

        return ResponseEntity.ok(
                mapper.toResponse(useCase.buscar(id))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalResponse> atualizar(
            @PathVariable String id,
            @RequestBody AnimalRequest request) {

        return ResponseEntity.ok(
                mapper.toResponse(useCase.atualizar(id, request))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        useCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
