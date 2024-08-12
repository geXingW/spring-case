package com.gexingw.transaction.message.support;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author GeXingW
 */
@Component
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class MessageSender {

    private final ApplicationEventPublisher eventPublisher;

    private final RabbitTemplate rabbitTemplate;

    public void send(ApplicationEvent applicationEvent) {

        // 同步消息
        if (applicationEvent instanceof SyncEvent) {
            eventPublisher.publishEvent(applicationEvent);
        }

        // 异步消息
        if (applicationEvent instanceof AsyncEvent) {
            new Thread(() -> eventPublisher.publishEvent(applicationEvent));
        }

        // MQ消息
        if (applicationEvent instanceof MsgQueueEvent) {
            MsgQueueEvent msgQueueEvent = (MsgQueueEvent) applicationEvent;
            rabbitTemplate.convertAndSend(msgQueueEvent.getExchange(), msgQueueEvent.getRoutingKey());
        }

        // 事务消息
        if (applicationEvent instanceof TransactionEvent) {

        }


    }

}
