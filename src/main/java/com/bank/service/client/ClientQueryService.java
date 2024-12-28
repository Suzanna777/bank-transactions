package com.bank.service.client;

import com.bank.domain.model.Client;
import com.bank.service.QueryService;

import java.util.UUID;

public interface ClientQueryService extends QueryService<Client> {
    Client getByUsername(String username);

    boolean existsByUsername(String username);

    Client getByAccount(UUID accountId);

}
