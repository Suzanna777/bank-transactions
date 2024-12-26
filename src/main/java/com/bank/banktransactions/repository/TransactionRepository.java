package com.bank.banktransactions.repository;

import com.bank.banktransactions.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

 }
