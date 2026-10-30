package io.github.kia.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {

    private static final String EXCHANGE = "otp.exchange";
    private static final String QUEUE = "otp.queue";
    private static final String ROUTING_KEY = "otp.routingkey";


    @Bean
    public DirectExchange otpExchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }

    @Bean
    public Queue otpQueue() {
        return QueueBuilder.durable(QUEUE).build();
    }

    @Bean
    public Binding otpBinding() {
        return BindingBuilder
                .bind(otpQueue())
                .to(otpExchange())
                .with(ROUTING_KEY);
    }


}
