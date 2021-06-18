package ru.student.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.student.data.model.Bet;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
public class EventDto {
  private Integer id;
  private Timestamp date;
  private String name;
  private String home;
  private String away;
  private List<Bet> bets;
}
