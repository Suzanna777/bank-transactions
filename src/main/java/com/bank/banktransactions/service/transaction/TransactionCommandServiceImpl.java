package com.bank.banktransactions.service.transaction;

import com.bank.banktransactions.domain.model.Transaction;
import com.bank.banktransactions.event.TransactionCreateEvent;
import com.bank.banktransactions.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCommandServiceImpl implements TransactionCommandService{

    private final EventService eventService;

    @Override
    public void create(Transaction object) {
        TransactionCreateEvent event = new TransactionCreateEvent(object);
        eventService.create(event);
    }
}
