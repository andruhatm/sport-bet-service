package ru.student.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class League {
  @JsonProperty("id")
  private Long id;

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
