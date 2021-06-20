package ru.student.data.mapstruct;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.student.data.dto.BetDto;
import ru.student.data.dto.EventDto;
import ru.student.data.dto.UserDto;
import ru.student.data.model.Bet;
import ru.student.data.model.Event;
import ru.student.data.model.User;

import java.util.List;

/**
 * Маппер для событий
 */
@Mapper(componentModel = "spring", uses = {UserStruct.class, CurrencyStruct.class, BetStruct.class})
public abstract class EventStruct {
  @Autowired
  private UserStruct userStruct;

  @Autowired
  private CurrencyStruct currencyStruct;

  @Autowired
  private BetStruct betStruct;

  public abstract EventDto toDto(Event event);

  public abstract Event fromDto(EventDto eventDto);

  public abstract List<EventDto> toDto(List<Event> events);

  public abstract List<Event> fromDto(List<EventDto> eventDtos);

}
