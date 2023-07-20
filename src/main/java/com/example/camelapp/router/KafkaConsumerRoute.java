package com.example.camelapp.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:kafka.demo.topic1?brokers=localhost:9092&groupId=group-1")
                .log("Received message from Kafka: ${body}");
    }
}