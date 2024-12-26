package com.bank.banktransactions.service.event;

import com.bank.banktransactions.domain.aggregate.Aggregate;
import com.bank.banktransactions.event.AbstractEvent;
import com.bank.banktransactions.event.EventType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountCreateEvent extends AbstractEvent {

    public AccountCreateEvent( Object payload) {
        super(null, EventType.ACCOUNT_CREATE, payload);
    }


    @Override
    public void apply(Aggregate aggregate) {

    }
}
