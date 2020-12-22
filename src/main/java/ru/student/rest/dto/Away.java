package ru.student.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Away {
  @JsonProperty("id")
  private Long away_id;

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
