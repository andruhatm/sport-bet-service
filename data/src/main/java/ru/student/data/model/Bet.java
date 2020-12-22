package ru.student.data.model;

import javax.persistence.*;

@Entity
@Table(name = "bets", schema = "public")
public class Bet {

  @Id
  @Column(name = "bet_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "event_id")
  private Event event;

  @ManyToOne(targetEntity = Currency.class)
  @JoinColumn(name = "currency_id")
  private Currency currency;

  @ManyToOne(targetEntity = User.class)
  @JoinColumn(name = "client_id")
  private User user;

  @Column(name = "amount")
  private Double amount;

  @Column(name = "prediction")
  private String winner;

  public Bet() {
  }

  public Bet(Event event, Currency currency, User user, Double amount, String winner) {
    this.event = event;
    this.currency = currency;
    this.user = user;
    this.amount = amount;
    this.winner = winner;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
