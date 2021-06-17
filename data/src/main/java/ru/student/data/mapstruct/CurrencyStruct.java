package ru.student.data.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import ru.student.data.dto.CurrencyDto;
import ru.student.data.dto.UserDto;
import ru.student.data.model.Currency;
import ru.student.data.model.User;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EventStruct.class, BetStruct.class, UserStruct.class})
public abstract class CurrencyStruct {

  @Autowired
  private UserStruct userStruct;

  @Autowired
  private EventStruct eventStruct;

  @Autowired
  private BetStruct betStruct;

  @Mappings({
    @Mapping(source = "id",target = "id"),
    @Mapping(source = "name",target = "name"),
    @Mapping(source = "exchange",target = "exchange"),

  })
  public abstract CurrencyDto toDto(Currency currency);

  public abstract Currency fromDto(CurrencyDto currencyDto);

  public abstract List<CurrencyDto> toDto(List<Currency> currencies);

  public abstract List<Currency> fromDto(List<CurrencyDto> currencyDtos);

}
