package com.gexingw.spring.rocketmq.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrderPayedMessage implements Serializable {

    public final static String TOPIC = "ORDER-TOPIC:payed";

    private Long id;

    private String message;

    public OrderPayedMessage(Long id) {
        this.id = id;
        this.message = "Order-" + id;
    }

}
