package ru.student.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.student.data.model.Bet;

import java.sql.Timestamp;
import java.util.List;

/**
 * дто события
 */
@Data
@NoArgsConstructor
public class EventDto {
  /**
   * айди события
   */
  private Integer id;
  /**
   * дата события
   */
  private Timestamp date;
  /**
   * имя события
   */
  private String name;
  /**
   * 1я команда
   */
  private String home;
  /**
   * 2я команда
   */
  private String away;
//  private List<Bet> bets;
}
