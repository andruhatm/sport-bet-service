package ru.student.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.student.data.model.Picture;

/**
 * Репозиторий для картинок.
 */
@Repository
public interface PictureRepo extends JpaRepository<Picture, Integer> {

    /**
     * Поиск картинки по ее названию.
     *
     * @param name название картинки
     * @return найденная картинка
     */
    Picture findByName(String name);
}
