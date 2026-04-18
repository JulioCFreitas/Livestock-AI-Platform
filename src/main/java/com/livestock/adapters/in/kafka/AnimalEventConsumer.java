package com.livestock.adapters.in.kafka;

import com.livestock.domain.event.AnimalCadastradoEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AnimalEventConsumer {

    @KafkaListener(
            topics = "animal-cadastrado",
            groupId = "agro-group"
    )
    public void consumir(AnimalCadastradoEvent event) {

        System.out.println("====================================");
        System.out.println("Evento de animal recebido");
        System.out.println("Identificação: " + event.getIdentificacao());
        System.out.println("====================================");
    }
}
