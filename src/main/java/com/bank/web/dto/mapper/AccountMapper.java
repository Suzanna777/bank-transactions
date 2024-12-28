package com.bank.web.dto.mapper;

import com.bank.domain.model.Account;
import com.bank.web.dto.AccountDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Mappable<Account, AccountDto> {

}
