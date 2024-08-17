package com.gexingw.spring.rocketmq.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrderPayedMessage extends OrderMessage {

    public OrderPayedMessage(Long id) {
        super(id, "payed");
    }

}
