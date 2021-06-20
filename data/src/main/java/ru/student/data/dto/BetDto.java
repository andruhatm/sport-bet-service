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

  /**
   * величина ставки
   */
  private Double amount;

  /**
   * имя команды предположительного победителя
   */
  private String winner;

  /**
   * имя команды победителя
   */
  private String real_winner;

  /**
   * поле события
   */
  private EventDto event;

  /**
   * тип валюты
   */
  private CurrencyDto currency;

  /**
   * поле пользователя
   */
  private UserDto user;

}
