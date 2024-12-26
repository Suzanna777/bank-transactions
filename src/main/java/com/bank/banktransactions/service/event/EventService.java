package com.bank.banktransactions.service.event;

import com.bank.banktransactions.event.AbstractEvent;

public interface EventService {
    void create(AbstractEvent event);

}
