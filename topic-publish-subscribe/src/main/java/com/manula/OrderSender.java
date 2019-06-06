package com.manula;

import static com.manula.ActiveMQConfig.ORDER_TOPIC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderSender {

    private static Logger log = LoggerFactory.getLogger(OrderSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendTopic(Order order) {
        log.info("sending with convertAndSend() to queue <" + order + ">");
        jmsTemplate.convertAndSend(ORDER_TOPIC, order);
    }

}
