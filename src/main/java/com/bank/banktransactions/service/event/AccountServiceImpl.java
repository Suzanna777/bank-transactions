package com.bank.banktransactions.service.event;

import com.bank.banktransactions.domain.model.Account;
import com.bank.banktransactions.service.account.AccountCommandService;
import com.bank.banktransactions.service.account.AccountQueryService;
import com.bank.banktransactions.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountQueryService queryService;
    private AccountCommandService commandService;

    @Override
    public void create(Account object) {
        commandService.create(object);
    }

    @Override
    public Account getByiD(UUID id) {
        return queryService.getByiD(id);
    }
}
