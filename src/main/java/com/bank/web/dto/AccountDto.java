package com.bank.web.dto;

import com.bank.web.dto.OnCreate;
import com.bank.web.dto.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class AccountDto {
    @NotNull(message = "id must be not null", groups = OnUpdate.class)
    @NotNull(message = "id must be null", groups = OnCreate.class)
    private UUID id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String number;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal balance;

}
