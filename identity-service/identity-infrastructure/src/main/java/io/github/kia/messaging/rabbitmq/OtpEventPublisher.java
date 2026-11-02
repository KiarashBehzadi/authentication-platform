package io.github.kia.messaging.rabbitmq;

import io.github.kia.messaging.event.OtpRequestEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class OtpEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public OtpEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(OtpRequestEvent event) {
        rabbitTemplate.convertAndSend(
                "otp.exchange",
                "otp.routingkey",
                event );
    }
}
