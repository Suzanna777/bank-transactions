package com.bank.service.client;

import com.bank.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientQueryService queryService;
    private final ClientCommandService commandService;
    @Override
    public void create(final Client object) {
      commandService.create(object);
    }

    @Override
    public Client getById(final UUID id) {
        return queryService.getById(id);
    }

    @Override
    public Client getByUsername(String username) {
        return queryService.getByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return queryService.existsByUsername(username);
    }
}
