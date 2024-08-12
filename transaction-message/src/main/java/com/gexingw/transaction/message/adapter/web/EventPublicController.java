package com.gexingw.transaction.message.adapter.web;

import com.gexingw.transaction.message.support.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GeXingW
 */
@RestController
@RequestMapping("event/publish")
@RequiredArgsConstructor(onConstructor_ = {@Lazy})
public class EventPublicController {

    private final MessageSender messageSender;

}
