package com.bank.banktransactions.service;

public interface CommandService<T> {
    void create(T object);

}
