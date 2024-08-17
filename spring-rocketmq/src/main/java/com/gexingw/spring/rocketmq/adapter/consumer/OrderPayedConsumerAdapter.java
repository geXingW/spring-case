package com.gexingw.spring.rocketmq.adapter.consumer;

import com.alibaba.fastjson.JSON;
import com.gexingw.spring.rocketmq.message.OrderCreatedMessage;
import com.gexingw.spring.rocketmq.message.OrderMessage;
import com.gexingw.spring.rocketmq.message.OrderPayedMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author GeXingW
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = "ORDER-TOPIC",
        consumerGroup = "order-payed-group",
        consumeMode = ConsumeMode.ORDERLY,
        selectorExpression = "payed"
)
public class OrderPayedConsumerAdapter implements RocketMQListener<OrderPayedMessage> {

    @Override
    public void onMessage(OrderPayedMessage message) {
        try {
            System.out.println("Payed Message：" + JSON.toJSONString(message));
//            log.info("Payed Message：{}", message);
        } catch (Exception e) {
            log.error("Payed Message 消费异常！{}", message, e);
        }
    }

}
