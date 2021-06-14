package ru.student.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.student.data.model.Photo;

/**
 * Репозиторий для фото профиля.
 *
 * @author andruha.tm
 */
@Repository
public interface PhotoRepo extends JpaRepository<Photo,Integer> {
}
