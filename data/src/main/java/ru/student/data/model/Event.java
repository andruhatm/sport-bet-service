package ru.student.data.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "events", schema = "public")
public class Event {

  @Id
  @Column(name = "event_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private Timestamp date;
  @Column
  private String name;
  @Column(name = "home_team")
  private String home;
  @Column(name = "away_team")
  private String away;

  public Event() {
  }

  public Event(Long id, Date date, String name, String home, String away) {
    this.id = id;
    this.date = new Timestamp(date.getTime()*1000);
    this.name = name;
    this.home = home;
    this.away = away;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHome() {
    return home;
  }

  public void setHome(String home) {
    this.home = home;
  }

  public String getAway() {
    return away;
  }

  public void setAway(String away) {
    this.away = away;
  }

  @Override
  public String toString() {
    return "Event{" +
      "id=" + id +
      ", date=" + date +
      ", name='" + name + '\'' +
      ", home='" + home + '\'' +
      ", away='" + away + '\'' +
      '}';
  }
}
