package com.gexingw.spring.rocketmq.adapter.producer;

import com.gexingw.spring.rocketmq.message.*;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        new Thread(() -> {
            for (long i = 0; i < 10; i = i + 2) {
                String key = String.valueOf(i);
                OrderCreatedMessage createdMessage = new OrderCreatedMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderCreatedMessage.TOPIC, createdMessage, key);
                OrderPayedMessage payedMessage = new OrderPayedMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderPayedMessage.TOPIC, payedMessage, key);
                OrderDeliveredMessage deliveredMessage = new OrderDeliveredMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderDeliveredMessage.TOPIC, deliveredMessage, key);
                System.out.println("顺序消息：order-" + i);
            }
        }).start();

        new Thread(() -> {
            for (long i = 1; i < 6; i = i + 2) {
                String key = String.valueOf(i);
                OrderCreatedMessage createdMessage = new OrderCreatedMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderCreatedMessage.TOPIC, createdMessage, key);
                OrderPayedMessage payedMessage = new OrderPayedMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderPayedMessage.TOPIC, payedMessage, key);
                OrderDeliveredMessage deliveredMessage = new OrderDeliveredMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderDeliveredMessage.TOPIC, deliveredMessage, key);
                System.out.println("顺序消息：order-" + i);
            }
        }).start();
    }

    @GetMapping("tag")
    public void tag() {
//        rocketMQTemplate.set

        new Thread(() -> {
            for (long i = 0; i < 10; i = i + 2) {
                String key = String.valueOf(i);
                OrderCreatedMessage createdMessage = new OrderCreatedMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderCreatedMessage.TOPIC, createdMessage, key);
                OrderPayedMessage payedMessage = new OrderPayedMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderPayedMessage.TOPIC, payedMessage, key);
                OrderDeliveredMessage deliveredMessage = new OrderDeliveredMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderDeliveredMessage.TOPIC, deliveredMessage, key);
                System.out.println("顺序消息：order-" + i);
            }
        }).start();

        new Thread(() -> {
            for (long i = 1; i < 6; i = i + 2) {
                String key = String.valueOf(i);
                OrderCreatedMessage createdMessage = new OrderCreatedMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderCreatedMessage.TOPIC, createdMessage, key);
                OrderPayedMessage payedMessage = new OrderPayedMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderPayedMessage.TOPIC, payedMessage, key);
                OrderDeliveredMessage deliveredMessage = new OrderDeliveredMessage(i);
                rocketMQTemplate.syncSendOrderly(OrderDeliveredMessage.TOPIC, deliveredMessage, key);
                System.out.println("顺序消息：order-" + i);
            }
        }).start();
    }

    @GetMapping("batch")
    public void batch() {
//        List<OrderMessage> messages = new ArrayList<>();
//        for (long i = 0; i < 10; i++) {
//            messages.add(new OrderCreatedMessage(i));
//            messages.add(new OrderPayedMessage(i));
//            messages.add(new OrderDeliveredMessage(i));
//        }
//        Collection<OrderMessage> messages1 = messages;

//        SendResult sendResult = rocketMQTemplate.syncSend(OrderMessage.ORDER_TOPIC_1, messages1);
    }

}
