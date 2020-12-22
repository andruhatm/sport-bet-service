package ru.student.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.student.data.model.Photo;

@Repository
public interface PhotoRepo extends JpaRepository<Photo,Integer> {
}
