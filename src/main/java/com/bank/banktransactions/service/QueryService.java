package com.bank.banktransactions.service;

import java.util.UUID;

public interface QueryService <T>{
    T getByiD(UUID id);

}
