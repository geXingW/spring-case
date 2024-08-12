package com.gexingw.transaction.message.domain;

import com.gexingw.transaction.message.support.MsgQueueEvent;
import lombok.Getter;

/**
 * @author GeXingW
 */
@SuppressWarnings("LombokGetterMayBeUsed")
public class MQDomainEvent implements MsgQueueEvent {

    @Getter
    private String exchange;

    @Getter
    private String routingKey;

}
