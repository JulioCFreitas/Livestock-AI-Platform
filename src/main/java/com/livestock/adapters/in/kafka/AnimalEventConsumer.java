package com.livestock.adapters.in.kafka;

import com.livestock.adapters.out.readmodel.AnimalReadModel;
import com.livestock.adapters.out.repository.AnimalReadRepository;
import com.livestock.domain.event.AnimalCadastradoEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AnimalEventConsumer {

    private final AnimalReadRepository repository;

    public AnimalEventConsumer(AnimalReadRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "animal-cadastrado", groupId = "agro-group")
    public void consumir(AnimalCadastradoEvent event) {

        AnimalReadModel readModel = new AnimalReadModel(
                event.getAnimalId(),
                event.getIdentificacao(),
                event.getTipo(),
                event.getPeso(),
                event.getDataNascimento()
        );

        repository.save(readModel);

        System.out.println("READ MODEL atualizado via Kafka");
    }
}
