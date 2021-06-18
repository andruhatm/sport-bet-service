package ru.student.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.student.data.model.Role;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto {
  private Integer id;
  private String username;
  private String password;
  private boolean active;
  private double balance;
  private List<BetDto> bets;
  private Set<Role> roles;
  private List<MediaDTO> medias;
//  private List<PhotoDto> photo;
}
