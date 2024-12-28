package com.bank.events;

import com.bank.domain.aggregate.Aggregate;

public interface Event {
    void apply(Aggregate aggregate);
}
