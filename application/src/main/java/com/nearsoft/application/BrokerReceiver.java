package com.nearsoft.application;

import com.google.gson.Gson;
import com.nearsoft.application.entities.FierroMessage;
import com.nearsoft.application.interfaces.ReceiverChannels;
import com.nearsoft.application.services.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding(ReceiverChannels.class)
@MessageEndpoint
@Profile("receiver")
public class BrokerReceiver {

    private MsgService msgService;

    @Autowired
    public BrokerReceiver(MsgService msgService) {
        this.msgService = msgService;
    }

    @ServiceActivator(inputChannel = ReceiverChannels.KAFKA)
    public void receiveMsgFromKafka(String msg) {
        FierroMessage fierroMessage = deserializeFierroMessage(msg);

        msgService.saveOrUpdate(fierroMessage);
        System.out.println(">>> Read from Kafka: " + fierroMessage.toString());
    }

    @ServiceActivator(inputChannel = ReceiverChannels.RABBIT)
    public void receiveMsgFromRabbit(String msg) {
        FierroMessage fierroMessage = deserializeFierroMessage(msg);

        msgService.saveOrUpdate(fierroMessage);
        System.out.println(">>> Read from RabbitMQ: " + fierroMessage.toString());
}

    private FierroMessage deserializeFierroMessage(String msg) {
        Gson gson = new Gson();
        return gson.fromJson(msg, FierroMessage.class);
    }
}