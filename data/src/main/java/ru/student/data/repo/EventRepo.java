package ru.student.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.student.data.model.Event;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Репозиторий для событий.
 *
 * @author andruha.tm
 */
@Repository
public interface EventRepo extends JpaRepository<Event,String> {

  Event getByName(String name);

  Event getAllByDateAfter(Timestamp date);
}
