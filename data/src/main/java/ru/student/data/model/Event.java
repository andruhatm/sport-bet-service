package ru.student.data.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Таблица событий.
 * @author andruha.tm
 */
@Entity
@Table(name = "events", schema = "public")
public class Event {

  /**
   * поле айди
   */
  @Id
  @Column(name = "event_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  /**
   * поле даты события
   */
  @Column
  private Timestamp date;

  /**
   * наименование события
   */
  @Column
  private String name;

  /**
   * имя домашней команды
   */
  @Column(name = "home_team")
  private String home;

  /**
   * имя приезжей команды
   */
  @Column(name = "away_team")
  private String away;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "event", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
  private List<Bet> bets;

  public Event() {
  }

  public Event(Integer id, Date date, String name, String home, String away) {
    this.id = id;
    this.date = new Timestamp(date.getTime()*1000);
    this.name = name;
    this.home = home;
    this.away = away;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Bet> getBets() {
    return bets;
  }

  public void setBets(List<Bet> bets) {
    this.bets = bets;
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
