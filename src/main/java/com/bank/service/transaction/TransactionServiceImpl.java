package com.bank.service.transaction;

import com.bank.domain.model.Transaction;
import com.bank.service.transaction.TransactionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{

    private final TransactionQueryService queryService;
    private final TransactionCommandService commandService;

    @Override
    public void create(final Transaction object) {
        commandService.create(object);
    }
    @Override
    public Transaction getByiD(final UUID id) {
        return queryService.getByiD(id);
    }



}
