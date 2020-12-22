package ru.student.data.dto;

public class BetDTO {
  private String winner;
  private Double money;
  private String currency;

  public String getWinner() {
    return winner;
  }

  public void setWinner(String winner) {
    this.winner = winner;
  }

  public Double getMoney() {
    return money;
  }

  public void setMoney(Double money) {
    this.money = money;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
