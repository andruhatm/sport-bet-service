package ru.student.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class MediaDTO {
  private Integer mediaID;
  private String fileName;
  private Integer width;
  private Integer height;
  private String securityUrl;
  private CategoriesMediaDTO categories;
  private UserDto user;
  private LocalDateTime dateAdded;
}
