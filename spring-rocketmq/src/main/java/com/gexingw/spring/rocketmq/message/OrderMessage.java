package com.gexingw.spring.rocketmq.message;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class OrderMessage implements Serializable {

    public final static String ORDER_TOPIC_1 = "ORDER-TOPIC-1";

    private Long id;

    private String flag;

    public OrderMessage(Long id, String flag) {
        this.id = id;
        this.flag = flag;
    }
}
