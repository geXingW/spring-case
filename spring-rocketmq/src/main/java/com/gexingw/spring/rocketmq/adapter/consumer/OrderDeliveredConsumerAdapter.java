package com.gexingw.spring.rocketmq.adapter.consumer;

import com.alibaba.fastjson.JSON;
import com.gexingw.spring.rocketmq.message.OrderCreatedMessage;
import com.gexingw.spring.rocketmq.message.OrderDeliveredMessage;
import com.gexingw.spring.rocketmq.message.OrderMessage;
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
        consumerGroup = "order-delivered-group",
        consumeMode = ConsumeMode.ORDERLY,
        selectorExpression = "delivered"
)
public class OrderDeliveredConsumerAdapter implements RocketMQListener<OrderDeliveredMessage> {

    @Override
    public void onMessage(OrderDeliveredMessage message) {
        try {
            System.out.println("Delivered Message：" + JSON.toJSONString(message));
//            log.info("Delivered Message：{}", message);
        } catch (Exception e) {
            log.error("Delivered Message 消费异常！{}", message, e);
        }
    }

}
