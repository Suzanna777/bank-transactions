package com.bank.events;

import com.bank.domain.aggregate.Aggregate;
import com.bank.domain.model.Client;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientCreateEvent extends AbstractEvent {

    public ClientCreateEvent(final Client payload){
        super(null, EventType.CLIENT_CREAT, payload);
    }

    @Override
    public void apply(final Aggregate aggregate) {

    }
}
