package com.example.camelapp.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:myTimer?period=5000")
                .setBody().simple("Hello, Camel!")
                .to("log:myLogger");
    }
}