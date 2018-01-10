package com.poker.userservice.message.configuration;

import com.poker.userservice.message.inbound.GameMessageConsumer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class EventConsumerCfg implements RabbitListenerConfigurer{
    public static final String USER_QUEUE = "userQueue";
    private static final String EXCHANGE = "pokerExchange";

    @Bean
    public TopicExchange consumerExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue queue() {
        return new Queue(USER_QUEUE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange consumerExchange) {
        return BindingBuilder
                .bind(queue)
                .to(consumerExchange)
                .with("game.*");
    }

    @Bean
    public GameMessageConsumer eventConsumer() {
        return new GameMessageConsumer();
    }

    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }

    @Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(consumerJackson2MessageConverter());
        return factory;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
        rabbitListenerEndpointRegistrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }
}
