package com.bank.web.dto.mapper;

import com.bank.domain.model.Client;
import com.bank.web.dto.ClientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends Mappable<Client, ClientDto> {

}
