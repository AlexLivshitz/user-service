package com.poker.userservice.message.inbound;

import com.poker.userservice.message.configuration.EventConsumerCfg;
import com.poker.userservice.message.inbound.event.GameCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class  GameMessageConsumer {
    private Logger logger = LoggerFactory.getLogger(GameMessageConsumer.class);

    @RabbitListener(queues= EventConsumerCfg.USER_QUEUE)
    public void receive(GameCreatedEvent message) {
        logger.info("Received message - {} ", message.toString());
    }
}
