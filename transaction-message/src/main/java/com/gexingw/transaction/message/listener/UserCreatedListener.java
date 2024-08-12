package com.gexingw.transaction.message.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author GeXingW
 */
@Slf4j
@Component
public class UserCreatedListener {

    @EventListener
    public void createdListener(SyncEvent syncEvent) {
        log.info("Event: " + syncEvent.toString());
    }

}
