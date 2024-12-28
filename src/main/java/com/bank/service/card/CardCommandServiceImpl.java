package com.bank.service.card;

import com.bank.domain.model.Card;
import com.bank.events.CardCreateEvent;
import com.bank.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CardCommandServiceImpl implements CardCommandService{

    private final EventService eventService;
    @Override
    public void create(final Card object) {
        CardCreateEvent event = new CardCreateEvent();
        eventService.create(event);

    }
}
