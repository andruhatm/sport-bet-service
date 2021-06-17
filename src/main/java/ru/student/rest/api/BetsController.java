package ru.student.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.student.data.dto.BetDto;
import ru.student.data.mapstruct.BetStruct;
import ru.student.data.model.Bet;
import ru.student.data.model.Currency;
import ru.student.data.model.Event;
import ru.student.data.model.User;
import ru.student.data.repo.BetRepo;
import ru.student.data.repo.CurrencyRepo;
import ru.student.data.repo.EventRepo;
import ru.student.data.repo.UserRepo;

import java.security.Principal;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Контроллер для Ставок.
 *
 * @author andruha.tm
 */
@RestController
@RequestMapping("/bets/")
public class BetsController {
  /**
   * поле репозитория событий
   */
  private final EventRepo eventRepo;
  /**
   * поле репозитория пользователей
   */
  private final UserRepo userRepo;
  /**
   * поле репозитория ставок
   */
  private final BetRepo betRepo;
  /**
   * поле репозитория валюты
   */
  private final CurrencyRepo currencyRepo;
  /**
   * Маппер для ставок
   */
  private final BetStruct betStruct;

  @Autowired
  public BetsController(EventRepo eventRepo, UserRepo userRepo, BetRepo betRepo, CurrencyRepo currencyRepo, BetStruct betStruct) {
    this.currencyRepo = currencyRepo;
    this.eventRepo = eventRepo;
    this.betStruct = betStruct;
    this.userRepo = userRepo;
    this.betRepo = betRepo;
  }

  /**
   * Создание новой ставки
   *
   * @param userId айди пользователя
   * @param betDTO данные ставки
   * @return сохраненная ставка
   */
  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BetDto> placeBet(
    Integer userId,
    @RequestBody BetDto betDTO
  ) {
//    String event1 = event.replace("+", " ");

    if (betDTO == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Event event2 = eventRepo.getById(betDTO.getEvent().getId());
    Bet bet = betStruct.fromDto(betDTO);
//    User user = userRepo.findById(userId);

    //generating result of game
    int i = ThreadLocalRandom.current().nextInt(0, 1);
    if (i != 1) {
      bet.setReal_winner(event2.getHome());
    } else {
      bet.setReal_winner(event2.getAway());
    }

    User updatableUser = userRepo.findById(userId);
    //checks if winner equals to Clients prediction
    Currency currency = currencyRepo.getById(bet.getCurrency().getId());
    if (bet.getWinner().equals(bet.getReal_winner())) {
      updatableUser.setBalance(updatableUser.getBalance() + bet.getAmount() * currency.getExchange());
      userRepo.flush();
    } else {
      updatableUser.setBalance(updatableUser.getBalance() - bet.getAmount() * currency.getExchange());
      userRepo.flush();
    }
    bet.setUser(updatableUser);
    Bet newBet = betRepo.save(bet);

    return new ResponseEntity<>(betStruct.toDto(newBet), HttpStatus.CREATED);
  }

}
