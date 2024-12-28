package com.bank.service.account;

import com.bank.domain.model.Account;
import com.bank.service.CommandService;
import com.bank.service.QueryService;

public interface AccountService extends QueryService<Account> , CommandService<Account> {

}
