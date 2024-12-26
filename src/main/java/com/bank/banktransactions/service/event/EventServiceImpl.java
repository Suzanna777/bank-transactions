package com.bank.banktransactions.service.event;

import com.bank.banktransactions.event.AbstractEvent;
import com.bank.banktransactions.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl {
    private final EventRepository repository;

    public void create(AbstractEvent event){
        repository.save(event);
    }

}
