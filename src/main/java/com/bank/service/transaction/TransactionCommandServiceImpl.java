package com.bank.service.transaction;


import com.bank.domain.model.Transaction;
import com.bank.events.TransactionCreateEvent;
import com.bank.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionCommandServiceImpl implements TransactionCommandService{

    private final EventService eventService;

    @Override
    public void create(final Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }

    //     private final CardService cardService;



}
