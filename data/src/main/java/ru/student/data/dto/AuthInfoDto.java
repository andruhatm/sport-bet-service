package ru.student.data.dto;

import java.util.Objects;
import java.util.UUID;

/**
 * dto авторизации
 */
public class AuthInfoDto {
    private String token;
    private Integer id;

  public AuthInfoDto(String token, Integer id) {
    this.token = token;
    this.id = id;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthInfoDto authInfo = (AuthInfoDto) o;
        return Objects.equals(token, authInfo.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}
