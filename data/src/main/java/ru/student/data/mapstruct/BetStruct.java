package ru.student.data.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import ru.student.data.dto.BetDto;
import ru.student.data.dto.CurrencyDto;
import ru.student.data.model.Bet;

import java.util.Currency;
import java.util.List;

/**
 * Маппер для ставок
 */
@Mapper(componentModel = "spring", uses = {UserStruct.class, CurrencyStruct.class, EventStruct.class})
public abstract class BetStruct {

  @Autowired
  private UserStruct userStruct;

  @Autowired
  private CurrencyStruct currencyStruct;

  @Autowired
  private EventStruct eventStruct;

  public abstract BetDto toDto(Bet bet);

  public abstract Bet fromDto(BetDto betDto);

  /**
   * Превращение списка Bet в список BetDto.
   *
   * @param bets список Bet
   * @return список BetDto
   */
  public abstract List<BetDto> toDto(List<Bet> bets);

  public abstract List<Bet> fromDto(List<BetDto> bets);
}
