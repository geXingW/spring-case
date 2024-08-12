package com.gexingw.transaction.message.adapter.mq;

import com.gexingw.transaction.message.domain.user.event.UserLoggedInEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author GeXingW
 */
@Slf4j
@Component
public class UserEventListener {

    @RabbitListener(queues = "user-logged-in")
    public void onUserLoggedIn(UserLoggedInEvent loggedInEvent) {

        log.info("收到用户登录成功的消息！{}");
    }

}
