package com.livestock.adapters.in.kafka;

import com.livestock.domain.event.ClienteCadastradoEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ClienteEventConsumer {

    @KafkaListener(
            topics = "cliente-cadastrado",
            groupId = "agro-group"
    )
    public void consumir(ClienteCadastradoEvent event) {

        System.out.println("====================================");
        System.out.println("Evento recebido do Kafka");
        System.out.println("Nome: " + event.getNome());
        System.out.println("====================================");

    }
}
