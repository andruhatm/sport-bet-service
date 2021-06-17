package ru.student.data.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Таблица фото профиля.
 * @author andruha.tm
 */
@Entity
@Table(name = "photos", schema = "public")
public class Photo {

  /**
   * айди файла
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "file_id")
  private Integer id;

  /**
   * имя файла
   */
  @Column(name = "name", nullable = false)
  private String name;

  /**
   * тип файла
   */
  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "data", nullable = false)
  @Lob
  @Type(type = "org.hibernate.type.BinaryType")
  private byte[] data;

//  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "client_id")
//  private User user;

  public Photo() {
  }

  public Photo(String name, String type, byte[] data) {
    this.name = name;
    this.type = type;
    this.data = data;
  }

//  public User getUser() {
//    return user;
//  }
//
//  public void setUser(User user) {
//    this.user = user;
//  }

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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }
}
