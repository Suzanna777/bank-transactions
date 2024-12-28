package com.bank.service;

public interface CommandService<T> {
    void create(T object);

}
