package com.gexingw.spring.rocketmq.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrderDeliveredMessage implements Serializable {

    public final static String TOPIC = "ORDER-TOPIC:delivered";

    private Long id;

    private String message;

    public OrderDeliveredMessage(Long id) {
        this.id = id;
        this.message = "Order-" + id;
    }

}
