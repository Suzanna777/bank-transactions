package com.bank.service.transaction;

import com.bank.domain.model.Transaction;
import com.bank.service.CommandService;
import com.bank.service.QueryService;

public interface TransactionService extends CommandService<Transaction>, QueryService<Transaction>  {
}
