package com.nearsoft.application.interfaces;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SenderChannels {

    @Output
    MessageChannel kafkaOutput();

    @Output
    MessageChannel rabbitOutput();
}
