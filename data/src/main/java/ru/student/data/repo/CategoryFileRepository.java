package ru.student.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.student.data.model.CategoryFile;

@Repository
public interface CategoryFileRepository extends JpaRepository<CategoryFile, Integer> {
}
