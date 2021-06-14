package ru.student.data.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Таблица ставки.
 * @author andruha.tm
 */
@Entity
@Table(name = "clients", schema = "public")
public class User {
  /**
   * айди юзера
   */
  @Id
  @Column(name = "client_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * имя юзера
   */
  @Column
  private String username;
  /**
   * пароль юзера
   */
  @Column
  private String password;

  /**
   * поле фото
   */
  @ManyToOne(targetEntity = Photo.class)
  @JoinColumn(name = "photo_id")
  private Photo photo;

  /**
   * поле активности
   */
  @Column
  private boolean active;

  /**
   * баланс
   */
  @Column
  private double balance;

  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
  @Enumerated(EnumType.STRING)
  private Set<Role> roles;

//  @JoinTable(name = "roles",joinColumns = @JoinColumn(name = "user_id"))

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Photo getPhoto() {
    return photo;
  }

  public void setPhoto(Photo photo) {
    this.photo = photo;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", photo=" + photo +
      ", active=" + active +
      '}';
  }
}
