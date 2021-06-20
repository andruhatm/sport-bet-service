package ru.student.data.jackson.jacksonDto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dto класс для приезжей команды.
 *
 * @author andruha.tm
 */
public class Away {
  /**
   * поле айди
   */
  @JsonProperty("id")
  private Long away_id;
  /**
   * имя приезжей команды
   */
  @JsonProperty("name")
  private String away;

  public Long getAway_id() {
    return away_id;
  }

  public void setAway_id(Long away_id) {
    this.away_id = away_id;
  }

  public String getAway() {
    return away;
  }

  public void setAway(String away) {
    this.away = away;
  }
}
