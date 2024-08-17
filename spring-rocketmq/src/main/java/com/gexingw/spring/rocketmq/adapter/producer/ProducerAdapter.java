package com.gexingw.spring.rocketmq.adapter.producer;

import com.gexingw.spring.rocketmq.message.OrderCreatedMessage;
import com.gexingw.spring.rocketmq.message.OrderDeliveredMessage;
import com.gexingw.spring.rocketmq.message.OrderPayedMessage;
import com.gexingw.spring.rocketmq.message.UserMessage;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GeXingW
 */
@RestController
@RequestMapping("/message/producer")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProducerAdapter {

    private final RocketMQTemplate rocketMQTemplate;

    @GetMapping("sync")
    public void send() {
        UserMessage userMessage = new UserMessage(System.currentTimeMillis());
        SendResult sendResult = rocketMQTemplate.syncSend(UserMessage.USER_TOPIC_1, userMessage);
//        System.out.println(JSON.toJSONString(sendResult));
    }

    @GetMapping("delay")
    public void delay() {
        // 发送延迟5s的消息
        UserMessage userMessage = new UserMessage(System.currentTimeMillis());

        MessageBuilder<UserMessage> messageBuilder1 = MessageBuilder.withPayload(userMessage);
        messageBuilder1.setHeader(MessageConst.PROPERTY_DELAY_TIME_LEVEL, 10);
        Message<UserMessage> message = messageBuilder1.build();
        rocketMQTemplate.syncSend(UserMessage.USER_TOPIC_1, message);

//        MessageBuilder<UserMessage> messageBuilder2 = MessageBuilder.withPayload(userMessage);
//        Message<UserMessage> message2 = messageBuilder2.build();
//        rocketMQTemplate.syncSend(UserMessage.USER_TOPIC_1, message2, 3000, 5);

    }

    @GetMapping("orderly")
    public void orderly() {
        for (long i = 0; i < 10; i++) {
            String key = String.valueOf(i);
            OrderCreatedMessage createdMessage = new OrderCreatedMessage(i);
            rocketMQTemplate.syncSendOrderly(OrderCreatedMessage.ORDER_TOPIC_1, createdMessage, key);
            OrderPayedMessage payedMessage = new OrderPayedMessage(i);
            rocketMQTemplate.syncSendOrderly(OrderCreatedMessage.ORDER_TOPIC_1, payedMessage, key);
            OrderDeliveredMessage deliveredMessage = new OrderDeliveredMessage(i);
            rocketMQTemplate.syncSendOrderly(OrderCreatedMessage.ORDER_TOPIC_1, deliveredMessage, key);
            System.out.println("顺序消息：order-" + i);
        }
    }

}
