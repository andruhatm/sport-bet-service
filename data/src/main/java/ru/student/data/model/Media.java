package ru.student.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
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

  @CreationTimestamp
  @Column(name = "date_added")
  private LocalDateTime dateAdded;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "client_id", nullable = true)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "categories_file_categories_file_id", nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private CategoryFile categoriesFile;

}
