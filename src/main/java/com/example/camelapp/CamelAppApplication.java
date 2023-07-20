package com.example.camelapp;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CamelConfiguration.class)
public class CamelAppApplication  {


    public static void main(String[] args) {
        SpringApplication.run(CamelAppApplication.class, args);
    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//
//        CamelContext camelContext = new DefaultCamelContext();
//
//        camelContext.start();
//
//        // Send a message to the direct:start endpoint
//        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();
//        producerTemplate.sendBody("direct:start", "Hello, Camel!");
//
//        camelContext.stop();
//    }
//
//
//    @Bean
//    public CamelContext camelContext() {
//        // Create and configure your CamelContext here
//        return new DefaultCamelContext();
//    }
}
