package ru.student.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.student.data.model.Bet;

import java.util.List;

public interface BetRepo extends JpaRepository<Bet,String> {
  List<Bet> findAllByUser_Id(Long user_id);
}
