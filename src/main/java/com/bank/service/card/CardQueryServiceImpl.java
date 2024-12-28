package com.bank.service.card;

import com.bank.domain.exception.ResourceNotFoundException;
import com.bank.domain.model.Card;
import com.bank.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardQueryServiceImpl implements CardQueryService {

    private final CardRepository repository;

    @Override
    public Card getByiD(final UUID id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }


    @Override
    public boolean existsByNumberAndDate(String number, String date) {
        return repository.existsByNumberAndDate(number, date);
    }

    @Override
    public Card getByNumberAndDateAndCvv(String number, String date, String cvv) {
        return null;
    }

    @Override
    public Card getByNumberAndDate(String number, String date) {
        return null;
    }
}
