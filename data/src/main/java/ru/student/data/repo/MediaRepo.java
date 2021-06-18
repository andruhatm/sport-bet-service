package ru.student.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import ru.student.data.model.Media;

@Repository
public interface MediaRepo extends JpaRepository<Media,Integer> {
}
