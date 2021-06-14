package ru.student.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

/**
 * Dto класс для нового события.
 *
 * @author andruha.tm
 */
public class NewEvent {
  /**
   * айди события
   */
  @JsonProperty("id")
  private Long event_id;
  /**
   * дата
   */
  @JsonProperty("time")
  private Timestamp time;
  /**
   * имя события
   */
  @JsonProperty("league")
  private League league;
  /**
   * поле домашней команды
   */
  @JsonProperty("home")
  private Home home;
  /**
   * поле приезжей команды
   */
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
