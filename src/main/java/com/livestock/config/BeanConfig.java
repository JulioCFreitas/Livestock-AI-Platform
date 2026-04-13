package com.livestock.config;

import com.livestock.application.ports.AnimalRepository;
import com.livestock.application.service.CadastrarAnimalService;
import com.livestock.application.usecase.CadastrarAnimalUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CadastrarAnimalUseCase cadastrarAnimalUseCase(AnimalRepository repository) {
        return new CadastrarAnimalService(repository);
    }
}
