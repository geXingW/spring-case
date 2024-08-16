package com.gexingw.spring.rocketmq.adapter.consumer;

import com.alibaba.fastjson.JSON;
import com.gexingw.spring.rocketmq.message.UserMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author GeXingW
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = UserMessage.USER_TOPIC_1, consumerGroup = "user-group-1")
public class ConsumerAdapter implements RocketMQListener<UserMessage> {

    @Override
    public void onMessage(UserMessage message) {
        try {
            log.info("收到消息：{}", message);
        } catch (Exception e) {
            log.error("消费异常！{}", message, e);
        }
    }

}
