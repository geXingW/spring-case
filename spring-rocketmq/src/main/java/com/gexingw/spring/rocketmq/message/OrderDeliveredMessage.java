package com.gexingw.spring.rocketmq.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrderDeliveredMessage extends OrderMessage {

    public OrderDeliveredMessage(Long id) {
        super(id, "delivered");
    }

}
