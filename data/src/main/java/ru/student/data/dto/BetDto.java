package ru.student.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.student.data.model.User;

/**
 * Dto класс для ставки.
 *
 * @author andruha.tm
 */
@Data
@NoArgsConstructor
public class BetDto {

  /**
   * айди ставки
   */
  private Integer id;

  //required
  /**
   * величина ставки
   */
  private Double amount;

  //required
  /**
   * имя команды победителя
   */
  private String winner;

  private String real_winner;

  //required
  private EventDto event;

  //required
  /**
   * тип валюты
   */
  private CurrencyDto currency;

  //required
  private UserDto user;

}
