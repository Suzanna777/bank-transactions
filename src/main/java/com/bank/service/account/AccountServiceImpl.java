package com.bank.service.account;

import com.bank.domain.model.Account;
import com.bank.service.account.AccountQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountQueryService queryService;
    private final AccountCommandService commandService;

    @Override
    public void create(final Account object) {
        commandService.create(object);
    }

    @Override
    public Account getById(final UUID id) {
        return queryService.getById(id);
    }
}
