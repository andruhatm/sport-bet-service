package ru.student.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * дто валюты
 */
@Data
@NoArgsConstructor
public class CurrencyDto {

  /**
   * айди валюты
   */
  private Integer id;

  /**
   * имя валюты
   */
  private String name;

  /**
   * перевод
   */
  private Double exchange;

}
