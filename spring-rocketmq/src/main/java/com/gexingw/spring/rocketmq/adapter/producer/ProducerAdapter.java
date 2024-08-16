package com.gexingw.spring.rocketmq.adapter.producer;

import com.gexingw.spring.rocketmq.message.UserMessage;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GeXingW
 */
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class ProducerAdapter {

    private final RocketMQTemplate rocketMQTemplate;

    @GetMapping("send-sync/{id}")
    public void send(@PathVariable Long id) {
        UserMessage userMessage = new UserMessage(id);
        SendResult sendResult = rocketMQTemplate.syncSend(UserMessage.USER_TOPIC_1, userMessage);
//        System.out.println(JSON.toJSONString(sendResult));
    }

}
