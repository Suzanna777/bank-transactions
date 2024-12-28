package com.bank.web.dto.mapper;

import com.bank.domain.model.Card;
import com.bank.web.dto.CardDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends Mappable<Card, CardDto> {

}
