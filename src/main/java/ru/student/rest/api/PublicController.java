package ru.student.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.student.data.model.Role;
import ru.student.data.model.User;
import ru.student.data.repo.UserRepo;
import ru.student.rest.service.PhotoService;

import java.io.IOException;
import java.util.Collections;

/**
 * Контроллер для Регистрации.
 *
 * @author andruha.tm
 */
@RestController
public class PublicController {

  /**
   * поле репозитория пользователей
   */
  private final UserRepo userRepo;
  /**
   * поле репозитория фото
   */
  private final PhotoService photoService;

  @Autowired
  public PublicController(UserRepo userRepo, PhotoService photoService) {
    this.userRepo = userRepo;
    this.photoService = photoService;
  }

  /**
   * Получение главной страницы сайта
   * @param model модель для передачи данных
   * @return главную страницу
   */
  @GetMapping()
  @RequestMapping(
    value = {"/"}
  )
  public ModelAndView index(Model model){
    String msg = "Hello, user!!!";
    model.addAttribute("message",msg);
    return new ModelAndView("index");
  }

  /**
   * Получение страницы регистрации
   * @return страницу регистрации
   */
  @GetMapping("/register")
  public ModelAndView signUpForm(){
    return new ModelAndView("register");
  }

  /**
   * Регистрация пользователя
   * @param file картинка пользователя
   * @param user данные пользователя
   * @param model модель для передачи данных
   * @return страницу логина
   * @throws IOException
   */
  @PostMapping("/register")
  public ModelAndView signUpUser(@RequestParam MultipartFile file, User user, ModelMap model) throws IOException {

    User existingUser = userRepo.findByUsername(user.getUsername());
    if(existingUser != null){
      model.addAttribute("message","user exists");
      return new ModelAndView("register",model);
    }

    user.setBalance(0);
    user.setPhoto(photoService.store(file));
    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));

    userRepo.save(user);

    return new ModelAndView("redirect:/login");
  }

  /**
   * исключает ошибку отсутствия картинки сайта
   */
  @GetMapping("/favicon.ico")
  @ResponseBody
  void returnNoFavicon() {
  }

}
