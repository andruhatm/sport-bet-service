package ru.student.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.student.data.model.User;

/**
 * Репозиторий для пользователей.
 *
 * @author andruha.tm
 */
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
  User findByUsername(String username);

}
