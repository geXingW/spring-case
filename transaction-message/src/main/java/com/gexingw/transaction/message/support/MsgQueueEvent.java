package com.gexingw.transaction.message.support;

import com.gexingw.transaction.message.event.DomainEvent;

/**
 * @author GeXingW
 */
public interface MsgQueueEvent extends DomainEvent {

    public String getExchange();

    public String getRoutingKey();

}
