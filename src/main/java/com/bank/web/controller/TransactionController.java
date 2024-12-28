package com.bank.web.controller;

import com.bank.domain.model.Transaction;
import com.bank.service.card.CardService;
import com.bank.service.transaction.TransactionService;
import com.bank.web.dto.OnCreate;
import com.bank.web.dto.TransactionDto;
import com.bank.web.dto.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final CardService cardService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public void create(@RequestBody @Validated(OnCreate.class) final TransactionDto dto){

        if (!cardService.existsByNumberAndDate(dto.getTo().getNumber(), dto.getTo().getDate())){
            throw  new IllegalStateException("card does not exist");
        }
        Transaction transaction = transactionMapper.fromDto(dto);
        transactionService.create(transaction);
    }

    @GetMapping("/{id}")
    public TransactionDto getById(@PathVariable final UUID id){
       Transaction transaction = transactionService.getByiD(id);
       return transactionMapper.toDto(transaction);

    }




}
