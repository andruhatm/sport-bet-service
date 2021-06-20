package ru.student.data.model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class EntityNotFoundException extends Exception {
  private UUID uuid;
  private int id;
  private String clazzName;

  public EntityNotFoundException(UUID id, String clazzName) {
    super(String.format("'%s' is not found with id : '%s'", clazzName, id));
  }

  public EntityNotFoundException(int id, String clazzName) {
    super(String.format("'%s' is not found with id : '%s'", clazzName, id));
  }

  public EntityNotFoundException(String clazzName) {
    super(String.format("'%s' is not found ", clazzName));
  }
}
