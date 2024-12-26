package com.bank.banktransactions.event;

import com.bank.banktransactions.domain.aggregate.Aggregate;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientCreateEvent extends AbstractEvent {

    public ClientCreateEvent(Object payload){
        super(null, EventType.CLIENT_CREAT, payload);
    }

    @Override
    public void apply(Aggregate aggregate) {

    }
}
