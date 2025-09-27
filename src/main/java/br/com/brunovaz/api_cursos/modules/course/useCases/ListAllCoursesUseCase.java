package br.com.brunovaz.api_cursos.modules.course.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunovaz.api_cursos.modules.course.CourseEntity;
import br.com.brunovaz.api_cursos.modules.course.repository.CourseRepository;

@Service
public class ListAllCoursesUseCase {
    @Autowired
    CourseRepository courseRepository;

    public List<CourseEntity> execute(){
        return this.courseRepository.findAll();
    }
}
