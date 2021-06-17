package ru.student.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurrencyDto {

  private Integer id;

  private String name;

  private Double exchange;

}
