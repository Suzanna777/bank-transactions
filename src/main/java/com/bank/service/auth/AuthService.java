package com.bank.service.auth;

import com.bank.domain.model.Client;
import com.bank.web.dto.LoginRequestDto;
import com.bank.web.dto.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto request);
    void register(Client client);

}
