package com.bank.web.dto.mapper;

import com.bank.domain.model.Transaction;
import com.bank.web.dto.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends Mappable<Transaction, TransactionDto> {

}
