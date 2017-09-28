package com.nearsoft.application.interfaces;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ReceiverChannels {

    String KAFKA = "kafkaInput";
    String RABBIT = "rabbitInput";

    @Input(KAFKA)
    SubscribableChannel kafkaInput();

    @Input(RABBIT)
    SubscribableChannel rabbitInput();
}
