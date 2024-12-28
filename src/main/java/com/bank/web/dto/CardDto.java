package com.bank.web.dto;

import com.bank.web.dto.OnCreate;
import com.bank.web.dto.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CardDto {

    @NotNull(message = "id must be not null", groups = OnUpdate.class)
    @NotNull(message = "id must be null", groups = OnCreate.class)
    private UUID id;

    @NotNull(message = "card number must be not null", groups = OnCreate.class)
    @NotNull(message = "card number must be null", groups = OnCreate.class)
    private String number;

    @NotNull(message = "card date must be not null", groups = OnCreate.class)
    @NotNull(message = "card date must be null", groups = OnCreate.class)
    private String date;

    private String cvv;

}
