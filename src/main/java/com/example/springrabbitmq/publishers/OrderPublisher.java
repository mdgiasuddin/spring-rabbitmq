package com.example.springrabbitmq.publishers;

import com.example.springrabbitmq.dtos.Order;
import com.example.springrabbitmq.dtos.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static constants.AppConstant.EXCHANGE_NAME;
import static constants.AppConstant.ROUTING_KEY;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderPublisher {

    private final RabbitTemplate template;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESSING", "Order placed successfully with id: " + order.getOrderId());
        template.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, orderStatus);

        return "Order placed successfully with id: " + order.getOrderId();
    }
}
