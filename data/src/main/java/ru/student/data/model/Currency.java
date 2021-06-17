package ru.student.data.model;

import javax.persistence.*;

/**
 * Таблица валюты.
 * @author andruha.tm
 */
@Entity
@Table(name = "currency")
public class Currency {

  /**
   * поле айди
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "currency_id")
  private Integer id;

  /**
   * поле наименование валюты
   */
  @Column(name = "currency_type")
  private String name;

  /**
   * поле перевода валюты
   */
  @Column(name = "exchange")
  private Double exchange;

  public Currency() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getExchange() {
    return exchange;
  }

  public void setExchange(Double exchange) {
    this.exchange = exchange;
  }
}
