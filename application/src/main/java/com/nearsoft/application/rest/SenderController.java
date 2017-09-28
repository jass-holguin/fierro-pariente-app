package com.nearsoft.application.rest;

import com.google.gson.Gson;
import com.nearsoft.application.entities.FierroMessage;
import com.nearsoft.application.interfaces.SenderChannels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(SenderChannels.class)
@Profile("sender")
public class SenderController {

    private final MessageChannel rabbitOutput;
    private final MessageChannel kafkaOutput;

    @Autowired
    public SenderController(SenderChannels sender) {
        this.kafkaOutput = sender.kafkaOutput();
        this.rabbitOutput = sender.rabbitOutput();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/send")
    public void send(@RequestBody FierroMessage msg) {
        Gson gson = new Gson();
        Message<String> brokerMsg = MessageBuilder.withPayload(gson.toJson(msg)).build();

        kafkaOutput.send(brokerMsg);
        rabbitOutput.send(brokerMsg);
    }
}

