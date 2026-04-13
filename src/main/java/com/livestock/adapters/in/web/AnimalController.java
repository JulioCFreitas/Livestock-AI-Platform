package com.livestock.adapters.in.web;

import com.livestock.application.usecase.CadastrarAnimalCommand;
import com.livestock.application.usecase.CadastrarAnimalUseCase;
import com.livestock.domain.model.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final CadastrarAnimalUseCase useCase;

    public AnimalController(CadastrarAnimalUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<Animal> cadastrar(@RequestBody CadastrarAnimalRequest request) {

        Animal animal = useCase.executar(new CadastrarAnimalCommand(
                request.identificacao(),
                request.tipo(),
                request.raca(),
                request.peso(),
                request.dataNascimento()
        ));
        return ResponseEntity.ok(animal);
    }

}
