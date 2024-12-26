package com.bank.banktransactions.service.card;

import com.bank.banktransactions.domain.model.Card;
import com.bank.banktransactions.domain.model.Transaction;
import com.bank.banktransactions.service.CommandService;
import com.bank.banktransactions.service.QueryService;

public interface CardService extends QueryService<Card>, CommandService<Card> {
}
