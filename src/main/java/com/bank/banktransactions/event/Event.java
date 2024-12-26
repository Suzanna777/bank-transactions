package com.bank.banktransactions.event;

import com.bank.banktransactions.domain.aggregate.Aggregate;

public interface Event {
    void apply(Aggregate aggregate);
}
