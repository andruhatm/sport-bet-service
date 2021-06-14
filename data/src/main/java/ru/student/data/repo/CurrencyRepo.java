package ru.student.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.student.data.model.Currency;

/**
 * Репозиторий для валют.
 *
 * @author andruha.tm
 */
public interface CurrencyRepo extends JpaRepository<Currency,Integer> {
  Currency getById(Integer id);
}
