package com.bank.web.controller;

import com.bank.domain.model.Client;
import com.bank.service.auth.AuthService;
import com.bank.web.dto.ClientDto;
import com.bank.web.dto.LoginRequestDto;
import com.bank.web.dto.LoginResponseDto;
import com.bank.web.dto.OnCreate;
import com.bank.web.dto.mapper.ClientMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final ClientMapper clientMapper;

    @PostMapping("/register")
    public void register(@RequestBody @Validated(OnCreate.class) final ClientDto dto){
        Client client = clientMapper.fromDto(dto);
        authService.register(client);
    }

    @PostMapping("/login")
    public LoginResponseDto login( @RequestBody @Validated final LoginRequestDto dto){
        return authService.login(dto);
    }

}
