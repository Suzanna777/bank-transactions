package com.bank.service.event;

import com.bank.domain.model.Account;
import com.bank.service.account.AccountCommandService;
import com.bank.service.account.AccountQueryService;
import com.bank.service.account.AccountService;
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
