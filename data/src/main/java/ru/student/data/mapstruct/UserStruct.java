package ru.student.data.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.student.data.dto.UserDto;
import ru.student.data.model.User;

import java.util.List;

/**
 * Маппер для пользователя
 */
@Mapper(componentModel = "spring", uses = {MediaStruct.class, EventStruct.class, BetStruct.class, CurrencyStruct.class, PictureMapper.class})
public interface UserStruct {

  @Mapping(source = "user.medias", target = "medias")
  UserDto map(User user);

  @Mapping(target = "picture.id", source = "pictureId")
  User fromDto(UserDto user);

  List<UserDto> map(List<User> user);

  List<User> fromDto(List<UserDto> user);

}
