package com.bank.web.dto;

import com.bank.domain.model.Card;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class TransactionDto {

    @NotNull(message = "id must be not null", groups = OnCreate.class)
    @NotNull(message = "id must be null", groups = OnCreate.class)
    private UUID id;


    @NotNull(message = "sender card must be not null", groups = OnCreate.class)
    @NotNull(message = "sender card must be null")
    @Valid
    private CardDto from;


    @NotNull(message = "receiver card must be not null", groups = OnCreate.class)
    @NotNull(message = "receiver  card must be null")
    @Valid
    private CardDto to;

    @NotNull(message = "amount must be not null")
    @Positive(message = "amount must be positive")
    private BigDecimal amount;

}
