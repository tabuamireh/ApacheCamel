package com.example.camelapp;

import org.apache.camel.*;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.camelapp.router") // Adjust the package name to match your Camel routes and components
public class CamelConfiguration {

    public CamelConfiguration() {
        System.out.println("Camel Configuration started !!");
    }
    // Additional configuration or customizations can be added here

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired(required = false)
    private RoutesBuilder[] routesBuilders;

    /**
     * Spring-aware Camel context for the application. Auto-detects and loads all routes available in the Spring
     * context.
     */
    @Bean
    CamelContext camelContext() throws Exception {
        CamelContext camelContext = new SpringCamelContext(applicationContext);
        if (routesBuilders != null) {
            for (RoutesBuilder routesBuilder : routesBuilders) {
                camelContext.addRoutes(routesBuilder);
            }
        }
        return camelContext;
    }

    /**
     * Default producer template for the bootstrapped Camel context.
     */
    @Bean
    ProducerTemplate producerTemplate() throws Exception {
        return camelContext().createProducerTemplate();
    }

    /**
     * Default consumer template for the bootstrapped Camel context.
     */
    @Bean
    ConsumerTemplate consumerTemplate() throws Exception {
        return camelContext().createConsumerTemplate();
    }

    @Bean
    TypeConverter typeConverter() throws Exception {
        return camelContext().getTypeConverter();
    }
}
