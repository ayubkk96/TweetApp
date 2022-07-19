package com.example.tweetapp;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {


    @KafkaListener(topics="tweettopic",
            groupId = "first"
    )
    void listener(String data) {
        System.out.println("Listener received: " + data + "yayy");
    }

}
