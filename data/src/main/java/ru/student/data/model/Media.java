package ru.student.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import ru.student.data.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "media")
public class Media implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "media_id", unique = true, nullable = false)
  private Integer mediaID;

  @Column(name = "file_name", nullable = false)
  private String fileName;

  @Column(name = "width")
  private Integer width;

  @Column(name = "height")
  private Integer height;

  @Column(name = "security_url")
  private String securityUrl;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "client_id", nullable = true)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private User user;

}
