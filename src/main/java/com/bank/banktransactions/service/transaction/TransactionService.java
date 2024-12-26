package com.bank.banktransactions.service.transaction;

import com.bank.banktransactions.domain.model.Transaction;
import com.bank.banktransactions.service.CommandService;
import com.bank.banktransactions.service.QueryService;

public interface TransactionService extends QueryService<Transaction>, CommandService<Transaction> {
}
