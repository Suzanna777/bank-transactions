package com.bank.service.client;

import com.bank.domain.model.Client;
import com.bank.events.ClientCreateEvent;
import com.bank.service.event.EventService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientCommandServiceImpl implements ClientCommandService {

    private EventService eventService;
    @Override
    public void create(final Client object) {
        ClientCreateEvent event = new ClientCreateEvent();
        eventService.create(event);
    }
}
