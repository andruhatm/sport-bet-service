package ru.student.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Home {
  @JsonProperty("id")
  private Long home_id;

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
