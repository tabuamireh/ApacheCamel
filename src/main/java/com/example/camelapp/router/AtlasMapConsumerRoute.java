package com.example.camelapp.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class AtlasMapConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("kafka:kafka.demo.topic1?brokers=localhost:9092&groupId=group-1")
                .log(" Send >>>> ${body}  <<<< ")
                .to("atlasmap:classpath:atlasmap-mapping.adm")
                .log(" Received >>>> ${body}");
    }
}