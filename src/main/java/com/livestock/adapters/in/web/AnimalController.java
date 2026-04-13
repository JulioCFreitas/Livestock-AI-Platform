package com.livestock.adapters.in.web;

import com.livestock.application.usecase.CadastrarAnimalCommand;
import com.livestock.application.usecase.CadastrarAnimalUseCase;
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
    public void cadastrar(@RequestBody CadastrarAnimalRequest request) {

        useCase.executar(new CadastrarAnimalCommand(
                request.identificacao(),
                request.tipo(),
                request.raca(),
                request.peso(),
                request.dataNascimento()
        ));
    }

}
