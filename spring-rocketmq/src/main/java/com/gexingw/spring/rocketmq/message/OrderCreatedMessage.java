package com.gexingw.spring.rocketmq.message;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderCreatedMessage extends OrderMessage {

    public OrderCreatedMessage(Long id) {
        super(id, "created");
    }

}
