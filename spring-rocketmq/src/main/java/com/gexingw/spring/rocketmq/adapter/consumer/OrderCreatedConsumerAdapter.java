package com.gexingw.spring.rocketmq.adapter.consumer;

import com.alibaba.fastjson.JSON;
import com.gexingw.spring.rocketmq.message.OrderCreatedMessage;
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
        consumerGroup = "order-created-group",
        consumeMode = ConsumeMode.ORDERLY,
        selectorExpression = "created"
)
public class OrderCreatedConsumerAdapter implements RocketMQListener<OrderCreatedMessage> {

    @Override
    public void onMessage(OrderCreatedMessage message) {
        try {
            System.out.println("Created Message：" + JSON.toJSONString(message));
//            log.info("Created Message：{}", message);
        } catch (Exception e) {
            log.error("Created Message 消费异常！{}", message, e);
        }
    }

}
