package ru.student.data.model;

import javax.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "currency_id")
  private Integer id;

  @Column(name = "currency_type")
  private String name;

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
}
