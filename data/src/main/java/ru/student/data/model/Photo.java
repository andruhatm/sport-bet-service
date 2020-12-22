package ru.student.data.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "photos", schema = "public")
public class Photo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "file_id")
  private Long id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "type", nullable = false)
  private String type;
  public Photo() {
  }
  @Column(name = "data", nullable = false)
  @Lob
  @Type(type = "org.hibernate.type.BinaryType")
  private byte[] data;

  public Photo(String name, String type, byte[] data) {
    this.name = name;
    this.type = type;
    this.data = data;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
