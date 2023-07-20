package com.example.camelapp.web;



import com.example.camelapp.kafka.MsgProducer;
import com.example.camelapp.vm.MessageBodyVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/camel")
public class CamelApiResource {

    private final Logger log = LoggerFactory.getLogger(CamelApiResource.class);

    @Autowired
    private MsgProducer msgProducer;

    @PostMapping("/push-message")
    public MessageBodyVM push(@RequestBody MessageBodyVM message) throws Exception {

        pushMessage(message);

        return message;
    }


    public void pushMessage(MessageBodyVM message) {
        msgProducer.send(message);
    }
}
