package com.bank.web.controller;

import com.bank.domain.model.Card;
import com.bank.domain.model.Transaction;
import com.bank.service.card.CardService;
import com.bank.web.dto.CardDto;
import com.bank.web.dto.TransactionDto;
import com.bank.web.dto.mapper.CardMapper;
import com.bank.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create() {
        UUID id = UUID.randomUUID();
        cardService.createByClientId(id);

    }

    @GetMapping("/{id}")
    public CardDto getById(@PathVariable final UUID id) {
        Card card = cardService.getByiD(id);
        return cardMapper.toDto(card);
    }

    @GetMapping("/{id}/transactions")
    public List<TransactionDto> getTransactionsById(@PathVariable final UUID id) {
        Card card = cardService.getByiD(id);
        return transactionMapper.toDto(card.getTransactions());

    }


}
