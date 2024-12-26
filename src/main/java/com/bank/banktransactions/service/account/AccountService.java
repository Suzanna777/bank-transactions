package com.bank.banktransactions.service.account;

import com.bank.banktransactions.domain.model.Account;
import com.bank.banktransactions.service.CommandService;
import com.bank.banktransactions.service.QueryService;

public interface AccountService extends QueryService<Account> , CommandService<Account> {

}
