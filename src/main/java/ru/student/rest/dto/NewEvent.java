package ru.student.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class NewEvent {
  @JsonProperty("id")
  private Long event_id;
  @JsonProperty("time")
  private Timestamp time;
  @JsonProperty("league")
  private League league;
  @JsonProperty("home")
  private Home home;
  @JsonProperty("away")
  private Away away;

  public Long getEvent_id() {
    return event_id;
  }

  public void setEvent_id(Long event_id) {
    this.event_id = event_id;
  }

  public Timestamp getTime() {
    return time;
  }

  @JsonProperty("time")
  public void setTime(Timestamp time) {
    this.time = time;
    System.out.print(time);
    System.out.println(getHome());
  }

  public League getLeague() {
    return league;
  }

  public void setLeague(League league) {
    this.league = league;
  }

  public Home getHome() {
    return home;
  }

  public void setHome(Home home) {
    this.home = home;
  }

  public Away getAway() {
    return away;
  }

  public void setAway(Away away) {
    this.away = away;
  }
}
