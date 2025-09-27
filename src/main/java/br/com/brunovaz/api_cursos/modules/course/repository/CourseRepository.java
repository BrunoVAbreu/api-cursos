package br.com.brunovaz.api_cursos.modules.course.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brunovaz.api_cursos.modules.course.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity,UUID> {
    Optional<CourseEntity> findByid(UUID id);
    Optional<CourseEntity> findByName(String name);
    Optional<CourseEntity> findByCategory(String category);
    Optional<CourseEntity> findByNameAndCategory(String name, String category);
}
