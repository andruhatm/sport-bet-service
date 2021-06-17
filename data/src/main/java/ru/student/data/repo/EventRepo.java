package ru.student.data.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

  Page<Event> findAll(Pageable pageable);

  Event getByName(String name);

  Event getById(Integer event_id);

  Event getAllByDateAfter(Timestamp date);
}
