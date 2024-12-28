package com.bank.service.client;

import com.bank.domain.model.Client;
import com.bank.service.CommandService;
import com.bank.service.QueryService;

public interface ClientService extends QueryService<Client>, CommandService<Client> {

    Client getByUsername(String username);

    boolean existsByUsername(String username);

}
