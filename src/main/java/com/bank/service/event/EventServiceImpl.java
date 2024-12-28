package com.bank.service.event;

import com.bank.events.AbstractEvent;
import com.bank.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{

    private final EventRepository repository;

    public void create(AbstractEvent event){
        repository.save(event);
    }

}
