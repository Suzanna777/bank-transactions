package com.bank.service.account;

import com.bank.domain.model.Account;
import com.bank.events.AccountCreateEvent;
import com.bank.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService{

    private EventService eventService;
    @Override
    public void create(final Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }
}
