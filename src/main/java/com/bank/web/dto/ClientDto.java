package com.bank.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Getter
@Setter
public class ClientDto {

    @NotNull(message = "id must be not null", groups = OnCreate.class)
    @NotNull(message = "id must be null", groups = OnCreate.class)
    private UUID id;

    @NotNull(message = "name must be not null")
    @Length(min = 1, max = 255, message = "name length must be min and max")
    private String name;

    @Email(message = "username must have a valid email")
    @NotNull(message = "username must be not null")
    @Length(min = 1, max = 255, message = "username length must be min and max")
    private String username;

    @NotNull(message = "password must be not null")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
