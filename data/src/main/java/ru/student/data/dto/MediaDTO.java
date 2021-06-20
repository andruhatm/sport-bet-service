package ru.student.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * дто медиа
 */
@Data
@NoArgsConstructor
public class MediaDTO {
  /**
   * айди медиа
   */
  private Integer mediaID;
  /**
   * имя файла
   */
  private String fileName;
  /**
   * ширина картинки
   */
  private Integer width;
  /**
   * высоты картинки
   */
  private Integer height;
  /**
   * урл картинки
   */
  private String securityUrl;
  /**
   * категория
   */
  private CategoriesMediaDTO categories;
  /**
   * айди пользователя
   */
  private UserDto user;
  /**
   * айди медиа
   */
  private LocalDateTime dateAdded;
}
