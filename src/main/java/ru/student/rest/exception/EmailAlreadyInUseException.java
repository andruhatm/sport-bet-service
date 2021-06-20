package ru.student.rest.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Обработка ошибки почты
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EmailAlreadyInUseException extends Exception{
  private String email;

  public EmailAlreadyInUseException(String email) {
    super();
    this.email = email;
  }

  public EmailAlreadyInUseException(String message, String email) {
    super(message);
    this.email = email;
  }
}
