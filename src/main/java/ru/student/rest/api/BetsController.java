package ru.student.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.student.data.dto.BetDTO;
import ru.student.data.model.Bet;
import ru.student.data.model.Event;
import ru.student.data.repo.BetRepo;
import ru.student.data.repo.CurrencyRepo;
import ru.student.data.repo.EventRepo;
import ru.student.data.repo.UserRepo;

import java.security.Principal;

@RestController
public class BetsController {

  private final EventRepo eventRepo;

  private final UserRepo userRepo;

  private final BetRepo betRepo;

  private final CurrencyRepo currencyRepo;

  @Autowired
  public BetsController(EventRepo eventRepo, UserRepo userRepo, BetRepo betRepo, CurrencyRepo currencyRepo) {
    this.currencyRepo = currencyRepo;
    this.eventRepo = eventRepo;
    this.userRepo = userRepo;
    this.betRepo = betRepo;
  }

  @GetMapping("/bet")
  public ModelAndView newBetForm(Model model, @RequestParam(name = "event", required = true) String event){
    String event1 = event.replace("+", " ");
    model.addAttribute("event",eventRepo.getByName(event1));
    return new ModelAndView("makeBet");
  }

  @PostMapping("/bet")
  public ModelAndView placeBet(
    Principal principal,
    @RequestParam(name = "event", required = true) String event,
    BetDTO betDTO,
    Model model
  ){
    String event1 = event.replace("+", " ");
    Event event2 = eventRepo.getByName(event1);
    Bet bet = new Bet();
    bet.setUser(userRepo.findByUsername(principal.getName()));
    bet.setAmount(betDTO.getMoney());
    bet.setEvent(event2);
    switch (betDTO.getCurrency()){
      case "1":
        bet.setCurrency(currencyRepo.getById(1));
        break;
      case "2":
        bet.setCurrency(currencyRepo.getById(2));
        break;
      case "3":
        bet.setCurrency(currencyRepo.getById(3));
        break;
      default:
        bet.setCurrency(currencyRepo.getById(1));
    }
    if(betDTO.getWinner().equals("home")){
      bet.setWinner(event2.getHome());
    }
    else {
      bet.setWinner(event2.getAway());
    }
    System.out.println(bet.toString());
    betRepo.save(bet);

    return new ModelAndView("redirect:/events");
  }

}
