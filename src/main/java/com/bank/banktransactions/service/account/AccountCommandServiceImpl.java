package com.bank.banktransactions.service.account;

import com.bank.banktransactions.domain.model.Account;
import com.bank.banktransactions.service.event.AccountCreateEvent;
import com.bank.banktransactions.service.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountCommandServiceImpl implements AccountCommandService{

    private EventService eventService;
    @Override
    public void create(Account object) {
        AccountCreateEvent event = new AccountCreateEvent(object);
        eventService.create(event);
    }
}
