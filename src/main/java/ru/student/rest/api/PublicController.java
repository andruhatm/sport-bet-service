package ru.student.rest.api;

import config.secure.JwtSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.student.data.dto.AuthInfoDto;
import ru.student.data.dto.UserDto;
import ru.student.data.mapstruct.UserStruct;
import ru.student.data.model.Role;
import ru.student.data.model.User;
import ru.student.data.repo.UserRepo;
import ru.student.rest.exception.EmailAlreadyInUseException;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Collections;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Контроллер для Регистрации.
 *
 * @author andruha.tm
 */
@RestController
@RequestMapping("/security/")
public class PublicController {

  /**
   * поле репозитория пользователей
   */
  private final UserRepo userRepo;

  /**
   * Маппер для пользователей
   */
  private final UserStruct userStruct;

  /**
   * Енкодер пароля
   */
  private final PasswordEncoder passwordEncoder;

  /**
   * Генератор токенов
   */
  private final JwtSupplier jwtSupplier;

  @Autowired
  public PublicController(UserRepo userRepo, UserStruct userStruct, PasswordEncoder passwordEncoder, JwtSupplier jwtSupplier) {
    this.jwtSupplier = jwtSupplier;
    this.passwordEncoder = passwordEncoder;
    this.userStruct = userStruct;
    this.userRepo = userRepo;
  }

  /**
   * Регистрация пользователя
   *
   * @param userDTO данные пользователя
   * @return данные созданного пользователя
   * @throws EmailAlreadyInUseException почта занята
   * @throws IOException                io exc
   */
  @PostMapping(value = "", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDto> signUpUser(@RequestBody UserDto userDTO) throws IOException, EmailAlreadyInUseException {

    if (userDTO == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    var password = passwordEncoder.encode(userDTO.getPassword());
    userDTO.setPassword(password);
    User user = userStruct.fromDto(userDTO);
    user.setBalance(0);
    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));

    if (userRepo.findByUsername(userDTO.getUsername()) != null) {
      throw new EmailAlreadyInUseException(userDTO.getUsername());
    }

    return new ResponseEntity<>(userStruct.map(userRepo.save(user)), HttpStatus.CREATED);
  }

  /**
   * Логин пользователя
   *
   * @param loginUserDto данные для входа
   * @return токен и айди пользователя
   * @throws EntityNotFoundException пользователь не найден
   */
  @RequestMapping(method = POST, path = "/login")
  public ResponseEntity<AuthInfoDto> loginUser(@RequestBody UserDto loginUserDto) throws EntityNotFoundException {
    AuthInfoDto authInfoDto = null;

    var user = userRepo.findByUsername(loginUserDto.getUsername());
    if (user == null)
      throw new EntityNotFoundException(loginUserDto.getUsername());

    if (passwordEncoder.matches(loginUserDto.getPassword(), user.getPassword())) {
      authInfoDto = generateTokenFromUser(user);
    }
    return authInfoDto != null
      ? new ResponseEntity<AuthInfoDto>(authInfoDto, HttpStatus.OK)
      : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  public AuthInfoDto generateTokenFromUser(User user) {
    return new AuthInfoDto(jwtSupplier.createTokenForUser(user.getUsername()), user.getId());
  }

}
