package ru.student.data.sheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.student.data.model.Event;
import ru.student.data.repo.EventRepo;
import ru.student.data.jackson.jacksonDto.NewEvent;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class Sheduler {

  static final Logger logger = LoggerFactory.getLogger(Sheduler.class);

  private final EventRepo eventRepo;

  @Autowired
  public Sheduler(EventRepo eventRepo) {
    this.eventRepo = eventRepo;
  }

  @Scheduled(cron = "0 0 0/12 * * ?")
  public void main() throws JsonProcessingException {
    logger.info("migration begins");
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("https://betsapi2.p.rapidapi.com/v1/bet365/upcoming?sport_id=3"))
      .header("x-rapidapi-key", System.getenv("ACCESS_TOKEN"))
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
//      System.out.println(response);
      ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//      by api
      List<NewEvent> eventList = mapper.readValue(
        response.body().substring(67),
        mapper.getTypeFactory().constructCollectionType(List.class, NewEvent.class)
      );

      for(NewEvent event: eventList){
        Event existingEvent = eventRepo.getByName(event.getLeague().getName());
        if(existingEvent == null){
          System.out.println("new event");
          Event event1 = new Event(
            event.getEvent_id(),
            event.getTime(),
            event.getLeague().getName(),
            event.getHome().getHome(),
            event.getAway().getAway()
          );
          eventRepo.save(event1);
          System.out.println(event1);
        }
      }
    }
  }
}
