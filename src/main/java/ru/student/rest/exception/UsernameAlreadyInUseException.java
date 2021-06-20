package ru.student.rest.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Обработка ошибки юзернейма
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UsernameAlreadyInUseException extends Exception{
  private String username;

  public UsernameAlreadyInUseException(String username) {
    super();
    this.username = username;
  }

  public UsernameAlreadyInUseException(String message, String username) {
    super(message);
    this.username = username;
  }
}
