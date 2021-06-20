package ru.student.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.student.data.dto.BetDto;
import ru.student.data.dto.EventDto;
import ru.student.data.dto.UserDto;
import ru.student.data.mapstruct.BetStruct;
import ru.student.data.mapstruct.EventStruct;
import ru.student.data.mapstruct.UserStruct;
import ru.student.data.model.Bet;
import ru.student.data.repo.BetRepo;
import ru.student.data.model.Event;
import ru.student.data.model.User;
import ru.student.data.repo.EventRepo;
import ru.student.data.repo.UserRepo;

import java.util.*;

/**
 * Контроллер для действий пользователя.
 *
 * @author andruha.tm
 */
@RestController
@RequestMapping("/user/")
public class ServiceController {
  /**
   * поле репозитория пользователей
   */
  private final UserRepo userRepo;
  /**
   * поле репозитория событий
   */
  private final EventRepo eventRepo;
  /**
   * поле репозитория ставок
   */
  private final BetRepo betRepo;
  /**
   * Маппер для ставок
   */
  private final BetStruct betMapper;
  /**
   * Маппер для событий
   */
  private final EventStruct eventStruct;
  /**
   * Маппер для пользователей
   */
  private final UserStruct userStruct;

  @Autowired
  public ServiceController(UserRepo userRepo, EventRepo eventRepo, BetRepo betRepo, BetStruct betMapper, EventStruct eventStruct, UserStruct userStruct) {
    this.userRepo = userRepo;
    this.eventStruct = eventStruct;
    this.userStruct = userStruct;
    this.betMapper = betMapper;
    this.eventRepo = eventRepo;
    this.betRepo = betRepo;
  }

  /**
   * Получение данных пользователя
   *
   * @param userId айди пользователя
   * @return данные пользователя
   */
  @GetMapping(value = "{userId}/", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDto> getAccount(@PathVariable("userId") Integer userId) {

    if (userId == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    User existingUser = userRepo.findById(userId);
    return new ResponseEntity<>(this.userStruct.map(existingUser), HttpStatus.OK);
  }

  /**
   * Возвращает список ставок пользователя
   *
   * @param userId айди пользователя
   * @return ставки пользователя
   */
  @GetMapping("{userId}/bets")
  public ResponseEntity<List<BetDto>> getBets(@PathVariable("userId") Integer userId) {

    if (userId == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    User existingUser = userRepo.findById(userId);
    List<Bet> betList = new ArrayList<>();
    if (existingUser != null) {
      betList = new ArrayList<>(betRepo.findAllByUser_Id(existingUser.getId()));
    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(betMapper.toDto(betList), HttpStatus.OK);
  }

  /**
   * Получение доступных событий
   *
   * @param size кол-во событий
   * @param page номер страницы
   * @return страница отсортированных событий
   */
  @GetMapping("/events")
  public ResponseEntity<Map<String, Object>> getEvents(
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size
  ) {
    try {
      Pageable pageable = PageRequest.of(page, size, Sort.by("date").ascending());

      Page<Event> eventDTOList = eventRepo.findAll(pageable);

      Map<String, Object> resp = new HashMap<>();
      List<EventDto> sort = eventStruct.toDto(eventDTOList.getContent());

      resp.put("events", sort);
      resp.put("currentPage", eventDTOList.getNumber());
      resp.put("totalItems", eventDTOList.getTotalElements());
      resp.put("totalPages", eventDTOList.getTotalPages());

      return !eventDTOList.isEmpty()
        ? new ResponseEntity<>(resp, HttpStatus.OK)
        : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (
      Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
