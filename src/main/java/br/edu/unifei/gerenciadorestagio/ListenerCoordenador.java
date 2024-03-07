package br.edu.unifei.gerenciadorestagio;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerCoordenador {

    @KafkaListener(topics = "nova-oportunidade", groupId = "group-1")
    public void listen(String message) {
        System.out.println(message);
    }

}
