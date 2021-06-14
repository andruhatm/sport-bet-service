package ru.student.data.dto;

/**
 * Dto класс для ставки.
 *
 * @author andruha.tm
 */
public class BetDTO {
  /**
   * имя команды победителя
   */
  private String winner;
  /**
   * величина ставки
   */
  private Double money;
  /**
   * тип валюты
   */
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
