package com.manula;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.manula.ActiveMQConfig.ORDER_TOPIC;

import javax.jms.Session;

@Component
public class OrderConsumer {

    private static Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    @JmsListener(destination = ORDER_TOPIC, containerFactory = "topicListenerFactory")
    public void receiveTopicMessage(@Payload Order order,
                                    @Headers MessageHeaders headers,
                                    Message<?> message,
                                    Session session) {

        log.info("received <" + order + ">");
    }

}
