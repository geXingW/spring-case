package com.gexingw.transaction.message.domain.order.event;

import com.gexingw.transaction.message.event.DomainEvent;
import com.gexingw.transaction.message.support.TransactionEvent;
import lombok.Getter;

/**
 * @author GeXingW
 */
@Getter
public class OrderCreatedEvent implements DomainEvent, TransactionEvent {

}
