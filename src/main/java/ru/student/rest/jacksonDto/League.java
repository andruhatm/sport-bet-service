package ru.student.rest.jacksonDto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dto класс для названия события.
 *
 * @author andruha.tm
 */
public class League {
  @JsonProperty("id")
  private Long id;
  /**
   * название события
   */
  @JsonProperty("name")
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setHome(String home) {
    this.name = home;
  }
}
