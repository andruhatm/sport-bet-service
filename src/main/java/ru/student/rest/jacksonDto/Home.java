package ru.student.rest.jacksonDto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dto класс для домашней команды.
 *
 * @author andruha.tm
 */
public class Home {
  /**
   * айди команды
   */
  @JsonProperty("id")
  private Long home_id;
  /**
   * имя домашней команды
   */
  @JsonProperty("name")
  private String home;

  public Long getHome_id() {
    return home_id;
  }

  public void setHome_id(Long home_id) {
    this.home_id = home_id;
  }

  public String getHome() {
    return home;
  }

  public void setHome(String home) {
    this.home = home;
  }
}
