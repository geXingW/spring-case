package com.gexingw.transaction.message.domain.user.event;

import com.gexingw.transaction.message.event.DomainEvent;
import lombok.Getter;

/**
 * @author GeXingW
 */
@Getter
public class UserCreatedEvent implements DomainEvent {

    private final Long userId;

    public UserCreatedEvent(Long userId) {
        this.userId = userId;
    }

}
