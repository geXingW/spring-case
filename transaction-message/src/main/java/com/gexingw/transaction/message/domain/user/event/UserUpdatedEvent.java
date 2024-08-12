package com.gexingw.transaction.message.domain.user.event;

import com.gexingw.transaction.message.event.DomainEvent;
import com.gexingw.transaction.message.support.AsyncEvent;
import com.gexingw.transaction.message.support.SyncEvent;
import lombok.Getter;

/**
 * @author GeXingW
 */
@Getter
public class UserUpdatedEvent implements DomainEvent, AsyncEvent, SyncEvent {

    private final Long userId;

    public UserUpdatedEvent(Long userId) {
        this.userId = userId;
    }

}
