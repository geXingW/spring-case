package com.gexingw.spring.rocketmq.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrderCreatedMessage implements Serializable {

    public final static String TOPIC = "ORDER-TOPIC:created";

    private Long id;

    private String message;

    public OrderCreatedMessage(Long id) {
        this.id = id;
        this.message = "Order-" + id;
    }

}
