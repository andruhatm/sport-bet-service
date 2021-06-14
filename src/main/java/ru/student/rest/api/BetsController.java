package ru.student.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.student.data.dto.BetDTO;
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

	@Autowired
	public BetsController(EventRepo eventRepo, UserRepo userRepo, BetRepo betRepo, CurrencyRepo currencyRepo) {
		this.currencyRepo = currencyRepo;
		this.eventRepo = eventRepo;
		this.userRepo = userRepo;
		this.betRepo = betRepo;
	}

	/**
	 * Получение формы новой ставки
	 *
	 * @param model модель для передачи данных на форму
	 * @param event имя события
	 * @return страница новой ставкиы
	 */
	@GetMapping("/bet")
	public ModelAndView newBetForm(Model model, @RequestParam(name = "event", required = true) String event) {
		String event1 = event.replace("+", " ");
		model.addAttribute("event", eventRepo.getByName(event1));
		return new ModelAndView("makeBet");
	}

	/**
	 * Создание новой ставки
	 *
	 * @param principal текущий пользователь
	 * @param event     имя события
	 * @param betDTO    данные ставки
	 * @param model     модель для передачи данных на форму
	 * @return страницу событий
	 */
	@PostMapping("/bet")
	public ModelAndView placeBet(
					Principal principal,
					@RequestParam(name = "event", required = true) String event,
					BetDTO betDTO,
					Model model
	) {
		String event1 = event.replace("+", " ");
		Event event2 = eventRepo.getByName(event1);
		Bet bet = new Bet();
		bet.setUser(userRepo.findByUsername(principal.getName()));
		bet.setAmount(betDTO.getMoney());
		bet.setEvent(event2);
		switch (betDTO.getCurrency()) {
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
		if (betDTO.getWinner().equals("home")) {
			bet.setWinner(event2.getHome());
		} else {
			bet.setWinner(event2.getAway());
		}
		//generating result of game
		int i = ThreadLocalRandom.current().nextInt(0, 1);
		if (i != 1) {
			bet.setReal_winner(event2.getHome());
		} else {
			bet.setReal_winner(event2.getAway());
		}
		betRepo.save(bet);

		User updatableUser = userRepo.findByUsername(principal.getName());
		//checks if winner equals to Clients prediction
		Currency currency = currencyRepo.getById(bet.getCurrency().getId());
		if (bet.getWinner().equals(bet.getReal_winner())) {
			updatableUser.setBalance(updatableUser.getBalance() + bet.getAmount() * currency.getExchange());
			userRepo.flush();
		} else {
			updatableUser.setBalance(updatableUser.getBalance() - bet.getAmount() * currency.getExchange());
			userRepo.flush();
		}

		return new ModelAndView("redirect:/account");
	}

}
