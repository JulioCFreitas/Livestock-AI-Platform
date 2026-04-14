package com.livestock.adapters.out.kafka;

import com.livestock.domain.event.ClienteCadastradoEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClienteEventProducer {

    private final KafkaTemplate<String, ClienteCadastradoEvent> kafkaTemplate;

    public ClienteEventProducer(KafkaTemplate<String, ClienteCadastradoEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarEvento(ClienteCadastradoEvent event) {
        KafkaTemplate.send("Cliente-cadatrado");
    }
}
