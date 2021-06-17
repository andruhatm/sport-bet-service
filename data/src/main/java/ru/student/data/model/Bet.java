package ru.student.data.model;

import javax.persistence.*;

/**
 * Таблица ставки.
 * @author andruha.tm
 */
@Entity
@Table(name = "bets", schema = "public")
public class Bet {

  /**
   * поле айди
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bet_id")
  private Integer id;

  /**
   * поле величина ставки
   */
  @Column(name = "amount")
  private Double amount;

  /**
   * поле предположительный победитель
   */
  @Column(name = "prediction")
  private String winner;

  /**
   * поле победитель
   */
  @Column(name = "winner")
  private String real_winner;

  /**
   * поле события {@link Event}
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "event_id")
  private Event event;

  /**
   * поле валюты {@link Currency}
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "currency_id")
  private Currency currency;

  /**
   * поле юзера {@link User}
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id")
  private User user;


  public Bet() {
  }

  public Bet(Event event, Currency currency, User user, Double amount, String winner) {
    this.event = event;
    this.currency = currency;
    this.user = user;
    this.amount = amount;
    this.winner = winner;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getWinner() {
    return winner;
  }

  public void setWinner(String winner) {
    this.winner = winner;
  }

  public String getReal_winner() {
    return real_winner;
  }

  public void setReal_winner(String real_winner) {
    this.real_winner = real_winner;
  }

  @Override
  public String toString() {
    return "Bet{" +
      "id=" + id +
      ", event=" + event +
      ", currency=" + currency +
      ", user=" + user +
      ", amount=" + amount +
      ", winner='" + winner + '\'' +
      '}';
  }
}
