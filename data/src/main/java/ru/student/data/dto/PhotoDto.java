package ru.student.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhotoDto {

  private Integer id;

  private String name;

  private String type;

  private byte[] data;

  private UserDto user;
}
