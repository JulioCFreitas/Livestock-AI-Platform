package com.livestock.adapters.out.kafka;

import com.livestock.domain.event.AnimalCadastradoEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AnimalEventProducer {

    private final KafkaTemplate<String, AnimalCadastradoEvent> kafkaTemplate;

    public AnimalEventProducer(KafkaTemplate<String, AnimalCadastradoEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarEvento(AnimalCadastradoEvent event) {
        kafkaTemplate.send("animal-cadastrado", event);
        System.out.println("Evento enviado: " + event.getIdentificacao());
    }
}