package ru.student.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.student.data.model.User;

@Data
@NoArgsConstructor
/**
 * Dto класс для ставки.
 *
 * @author andruha.tm
 */
public class BetDto {

  private Integer id;

  /**
   * величина ставки
   */
  private Double amount;

  /**
   * имя команды победителя
   */
  private String winner;

  private String real_winner;

  private EventDto event;

  /**
   * тип валюты
   */
  private CurrencyDto currency;

  private UserDto user;

}
