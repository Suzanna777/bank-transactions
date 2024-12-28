package com.bank.service.auth;

import com.bank.domain.exception.ResourceAlreadyExistsException;
import com.bank.domain.model.Client;
import com.bank.service.client.ClientService;
import com.bank.web.dto.LoginRequestDto;
import com.bank.web.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final ClientService clientService;
    @Override
    public LoginResponseDto login(LoginRequestDto request) {
        return null;
        // TO DO
    }

    @Override
    public void register(Client client) {
        if (clientService.existsByUsername(client.getUsername())){
            throw new ResourceAlreadyExistsException();
        }
        client.setPassword(client.getPassword());
        clientService.create(client);
    }
}
