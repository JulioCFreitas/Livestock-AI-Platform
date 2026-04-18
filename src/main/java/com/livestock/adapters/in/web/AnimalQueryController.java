package com.livestock.adapters.in.web;

import com.livestock.adapters.out.readmodel.AnimalReadModel;
import com.livestock.adapters.out.repository.AnimalReadRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animais-view")
public class AnimalQueryController {

    private AnimalReadRepository repository;

    public AnimalQueryController(AnimalReadRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<AnimalReadModel> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public AnimalReadModel buscar(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrado."));
    }
}
