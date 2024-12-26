package com.bank.banktransactions.repository;

import com.bank.banktransactions.event.AbstractEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<AbstractEvent, Long > {

  }
