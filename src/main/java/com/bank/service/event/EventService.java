package com.bank.service.event;

import com.bank.events.AbstractEvent;

public interface EventService {
    void create(AbstractEvent event);

}
