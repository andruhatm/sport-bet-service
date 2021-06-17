package ru.student.data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
  private Integer id;

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
   * поле активности
   */
  @Column
  private boolean active;

  /**
   * баланс
   */
  @Column
  private double balance;

  /**
   * поле ставок
   */
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
  private List<Bet> bets;

  /**
   * поле фото
   */
//  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
//  private List<Photo> photo;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
  @org.hibernate.annotations.OrderBy(clause = "dateAdded DESC NULLS LAST")
  private List<Media> medias = new ArrayList<>();

  @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
  @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
  @Enumerated(EnumType.STRING)
  private Set<Role> roles;

  //  @JoinTable(name = "roles",joinColumns = @JoinColumn(name = "user_id"))


//  public void setPhoto(List<Photo> photo) {
//    this.photo = photo;
//  }


  public List<Media> getMedias() {
    return medias;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

//  public List<Photo> getPhoto() {
//    return photo;
//  }
//
//  public void setPhoto(Photo photo) {
//    this.photo.add(photo);
//  }

  public List<Bet> getBets() {
    return bets;
  }

  public void setBets(List<Bet> bets) {
    this.bets = bets;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void setMedias(List<Media> medias) {
    if (medias != null) {
      if (!this.medias.isEmpty()) {
        this.medias.clear();
      }
      this.medias.addAll(medias);
      for (Media m : medias) {
        m.setUser(this);
      }
    }
  }
  public void addMediaUser(Media media) {
    this.medias.add(media);
    media.setUser(this);
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", active=" + active +
      ", balance=" + balance +
      ", photo=" + medias +
      ", bets=" + bets +
      ", roles=" + roles +
      '}';
  }
}
