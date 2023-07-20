package com.example.camelapp.kafka;

import com.example.camelapp.vm.MessageBodyVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MsgProducer {

    @Autowired
    private KafkaTemplate<String, MessageBodyVM> kafkaTemplate;

    String kafkaTopic = "kafka.demo.topic1";

    public void send(MessageBodyVM message) {

        kafkaTemplate.send(kafkaTopic, message);
    }
}
