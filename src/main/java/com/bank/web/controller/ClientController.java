package com.bank.web.controller;

import com.bank.domain.model.Client;
import com.bank.service.client.ClientService;
import com.bank.web.dto.AccountDto;
import com.bank.web.dto.ClientDto;
import com.bank.web.dto.mapper.AccountMapper;
import com.bank.web.dto.mapper.CardMapper;
import com.bank.web.dto.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
@Validated
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final CardMapper cardMapper;
    private final AccountMapper accountMapper;

    @GetMapping("/{id")
    public ClientDto getById(@PathVariable  UUID id){
        Client client = clientService.getById(id);
        return clientMapper.toDto(client);

    }

    @GetMapping("/{id}/account")
    public AccountDto getAccountById(@PathVariable  UUID id){
        Client client = clientService.getById(id);
        return accountMapper.toDto(client.getAccount());
    }

}
