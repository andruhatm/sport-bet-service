package ru.student.rest.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.student.data.formatter.TimestampFormatter;
import ru.student.data.model.Bet;
import ru.student.data.repo.BetRepo;
import ru.student.rest.dto.NewEvent;
import ru.student.data.model.Event;
import ru.student.data.model.User;
import ru.student.data.repo.EventRepo;
import ru.student.data.repo.UserRepo;
import ru.student.rest.service.ImgEncoder;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
public class ServiceController {

  private final UserRepo userRepo;

  private final EventRepo eventRepo;

  private final BetRepo betRepo;

  @Autowired
  public ServiceController(UserRepo userRepo, EventRepo eventRepo, BetRepo betRepo) {
    this.userRepo = userRepo;
    this.eventRepo = eventRepo;
    this.betRepo = betRepo;
  }

  @GetMapping("/account")
  public ModelAndView getAccount(Principal principal, Model model) throws UnsupportedEncodingException {

    if(principal!=null){

      model.addAttribute("username",principal.getName());
      User existingUser = userRepo.findByUsername(principal.getName());

      if(existingUser != null){
        model.addAttribute("user",existingUser);
        model.addAttribute("encoder",new ImgEncoder());
        byte[] encodeBase64 = Base64.getEncoder().encode(existingUser.getPhoto().getData());
        String base64DataString = new String(encodeBase64 , StandardCharsets.UTF_8);

        model.addAttribute("photo",existingUser.getPhoto());
        model.addAttribute("base64DataString",base64DataString);
      }
    }
    return new ModelAndView("account");
  }

  @GetMapping("/mybets")
  public ModelAndView getBets(Principal principal, Model model) throws UnsupportedEncodingException {

    if(principal!=null){
      model.addAttribute("username",principal.getName());

      User existingUser = userRepo.findByUsername(principal.getName());
      if(existingUser != null){
        List<Bet> betList = new ArrayList<>(betRepo.findAllByUser_Id(existingUser.getId()));
        model.addAttribute("existingUser",existingUser);
        model.addAttribute("betList",betList);
      }
    }
    return new ModelAndView("main");
  }

  @GetMapping()
  @RequestMapping("/events")
  ModelAndView getEvents(Model model) throws IOException {

    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("https://betsapi2.p.rapidapi.com/v1/bet365/upcoming?sport_id=3"))
      .header("x-rapidapi-key", "0f5f6d83d7mshe1afc3e7efdd342p1572eajsn86d5ca57de38")
      .header("x-rapidapi-host", "betsapi2.p.rapidapi.com")
      .method("GET", HttpRequest.BodyPublishers.noBody())
      .build();
    HttpResponse<String> response = null;
    try {
      response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException | InterruptedException exception) {
      exception.printStackTrace();
    }

    if (response != null) {
      System.out.println("response not null");
      ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//      by api
      List<NewEvent> eventList = mapper.readValue(
        response.body().substring(66),
        mapper.getTypeFactory().constructCollectionType(List.class, NewEvent.class)
      );

//      by file
//      List<NewEvent> eventList = mapper.readValue(
//        "[{\"id\":\"95533420\",\"sport_id\":\"3\",\"time\":\"1607749500\",\"time_status\":\"0\",\"league\":{\"id\":\"10044601\",\"name\":\"Big Bash\"},\"home\":{\"id\":\"10446602\",\"name\":\"Melbourne Stars\"},\"away\":{\"id\":\"10444513\",\"name\":\"Sydney Thunder\"},\"ss\":null,\"our_event_id\":\"3019693\",\"r_id\":null,\"updated_at\":\"1607729389\"},{\"id\":\"96288033\",\"sport_id\":\"3\",\"time\":\"1607754600\",\"time_status\":\"0\",\"league\":{\"id\":\"10068023\",\"name\":\"Bangabandhu T20 Cup\"},\"home\":{\"id\":\"10514559\",\"name\":\"Rajshahi\"},\"away\":{\"id\":\"10514886\",\"name\":\"Chattogram\"},\"ss\":null,\"our_event_id\":\"3021843\",\"r_id\":null,\"updated_at\":\"1607729419\"},{\"id\":\"95533421\",\"sport_id\":\"3\",\"time\":\"1607760900\",\"time_status\":\"0\",\"league\":{\"id\":\"10044601\",\"name\":\"Big Bash\"},\"home\":{\"id\":\"10444516\",\"name\":\"Melbourne Renegades\"},\"away\":{\"id\":\"10444515\",\"name\":\"Perth Scorchers\"},\"ss\":null,\"our_event_id\":\"2940969\",\"r_id\":null,\"updated_at\":\"1607729389\"},{\"id\":\"96288051\",\"sport_id\":\"3\",\"time\":\"1607772600\",\"time_status\":\"0\",\"league\":{\"id\":\"10068023\",\"name\":\"Bangabandhu T20 Cup\"},\"home\":{\"id\":\"10514556\",\"name\":\"Barishal\"},\"away\":{\"id\":\"10514558\",\"name\":\"Dhaka\"},\"ss\":null,\"our_event_id\":\"3021844\",\"r_id\":null,\"updated_at\":\"1607729419\"},{\"id\":\"96257672\",\"sport_id\":\"3\",\"time\":\"1607810400\",\"time_status\":\"0\",\"league\":{\"id\":\"10043526\",\"name\":\"Ford Trophy\"},\"home\":{\"id\":\"10411499\",\"name\":\"Central Districts\"},\"away\":{\"id\":\"10411500\",\"name\":\"Canterbury\"},\"ss\":null,\"our_event_id\":\"2930403\",\"r_id\":null,\"updated_at\":\"1607729419\"},{\"id\":\"96257675\",\"sport_id\":\"3\",\"time\":\"1607810400\",\"time_status\":\"0\",\"league\":{\"id\":\"10043526\",\"name\":\"Ford Trophy\"},\"home\":{\"id\":\"10411503\",\"name\":\"Otago\"},\"away\":{\"id\":\"10411501\",\"name\":\"Northern Districts\"},\"ss\":null,\"our_event_id\":\"2930404\",\"r_id\":null,\"updated_at\":\"1607729419\"},{\"id\":\"96257679\",\"sport_id\":\"3\",\"time\":\"1607810400\",\"time_status\":\"0\",\"league\":{\"id\":\"10043526\",\"name\":\"Ford Trophy\"},\"home\":{\"id\":\"10411498\",\"name\":\"Auckland\"},\"away\":{\"id\":\"10411502\",\"name\":\"Wellington\"},\"ss\":null,\"our_event_id\":\"2930405\",\"r_id\":null,\"updated_at\":\"1607729419\"},{\"id\":\"95533422\",\"sport_id\":\"3\",\"time\":\"1607829300\",\"time_status\":\"0\",\"league\":{\"id\":\"10044601\",\"name\":\"Big Bash\"},\"home\":{\"id\":\"10447029\",\"name\":\"Adelaide Strikers\"},\"away\":{\"id\":\"10446790\",\"name\":\"Hobart Hurricanes\"},\"ss\":null,\"our_event_id\":\"3018919\",\"r_id\":null,\"updated_at\":\"1607729389\"}]}\n",
//        mapper.getTypeFactory().constructCollectionType(List.class, NewEvent.class)
//      );

      for(NewEvent event: eventList){
        Event exitstingEvent = eventRepo.getByName(event.getLeague().getName());
        if(exitstingEvent == null){
          Event event1 = new Event(
            event.getEvent_id(),
            event.getTime(),
            event.getLeague().getName(),
            event.getHome().getHome(),
            event.getAway().getAway()
          );
          eventRepo.save(event1);
          System.out.println(event1.toString());
        }
      }
      List<Event> dbeventsList = new ArrayList<>(eventRepo.findAll());
      model.addAttribute("formatter",new TimestampFormatter());
      model.addAttribute("dbEventsList",dbeventsList);
      return new ModelAndView("new");
    }
    else {
      System.out.println("response is null");
    }

    return new ModelAndView("new");
  }
}
