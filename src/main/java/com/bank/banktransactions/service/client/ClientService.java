package com.bank.banktransactions.service.client;

import com.bank.banktransactions.domain.model.Client;
import com.bank.banktransactions.service.CommandService;
import com.bank.banktransactions.service.QueryService;

public interface ClientService extends QueryService<Client>, CommandService<Client> {
}
