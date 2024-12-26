package com.bank.banktransactions.service.card;

import com.bank.banktransactions.domain.exception.ResourceNotFoundException;
import com.bank.banktransactions.domain.model.Card;
import com.bank.banktransactions.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository repository;

    @Override
    public Card getByiD(UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
