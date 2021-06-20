package ru.student.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * дто фото
 */
@Data
@NoArgsConstructor
public class PhotoDto {

  /**
   * айди фото
   */
  private Integer id;

  /**
   * имя фото
   */
  private String name;

  /**
   * тип медиа
   */
  private String type;

  /**
   * данные
   */
  private byte[] data;

  /**
   * юзер
   */
  private UserDto user;
}
