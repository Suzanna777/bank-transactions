package com.bank.service;

import java.util.UUID;

public interface QueryService <T>{
    T getByiD(UUID id);

}
