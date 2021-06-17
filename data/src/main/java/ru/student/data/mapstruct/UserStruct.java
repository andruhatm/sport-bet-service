package ru.student.data.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.student.data.dto.UserDto;
import ru.student.data.model.User;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MediaStruct.class, EventStruct.class, BetStruct.class, CurrencyStruct.class, PhotoStruct.class})
public interface UserStruct {

//  @Autowired
//  private EventStruct eventStruct;
//
//  @Autowired
//  private PhotoStruct photoStruct;
//
//  @Autowired
//  private CurrencyStruct currencyStruct;
//
//  @Autowired
//  private BetStruct betStruct;

  @Mapping(source = "user.medias", target = "medias")
  UserDto map(User user);

  User fromDto(UserDto user);

  List<UserDto> map(List<User> user);

  List<User> fromDto(List<UserDto> user);


}
