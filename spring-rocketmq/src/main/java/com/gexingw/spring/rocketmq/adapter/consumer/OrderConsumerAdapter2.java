package com.gexingw.spring.rocketmq.adapter.consumer;

import com.gexingw.spring.rocketmq.message.OrderCreatedMessage;
import com.gexingw.spring.rocketmq.message.OrderMessage;
import com.gexingw.spring.rocketmq.message.UserMessage;
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
@RocketMQMessageListener(topic = OrderCreatedMessage.ORDER_TOPIC_1, consumerGroup = "order-group-1", consumeMode = ConsumeMode.ORDERLY)
public class OrderConsumerAdapter2 implements RocketMQListener<OrderMessage> {

    @Override
    public void onMessage(OrderMessage message) {
        try {
            log.info("Adapter-2 收到消息：{}", message);
        } catch (Exception e) {
            log.error("Adapter-2 消费异常！{}", message, e);
        }
    }

}
