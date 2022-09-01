package com.example.springrabbitmq.consumers;

import com.example.springrabbitmq.dtos.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static constants.AppConstant.MESSAGE_QUEUE_NAME;

@Component
public class OrderConsumer {

    @RabbitListener(queues = MESSAGE_QUEUE_NAME)
    public void consumeOrderFromQueue(OrderStatus orderStatus) {
        System.out.println("Message received from queue: " + orderStatus);
    }
}
