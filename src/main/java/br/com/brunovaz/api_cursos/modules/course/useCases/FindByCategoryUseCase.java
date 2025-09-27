package br.com.brunovaz.api_cursos.modules.course.useCases;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunovaz.api_cursos.modules.course.CourseEntity;
import br.com.brunovaz.api_cursos.modules.course.repository.CourseRepository;

@Service
public class FindByCategoryUseCase {
    @Autowired
    CourseRepository courseRepository;

    public Optional<List<CourseEntity>> execute(String category){
        return this.courseRepository.findByCategory(category);
    }
}
