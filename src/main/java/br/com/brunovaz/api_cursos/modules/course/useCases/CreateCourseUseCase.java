package br.com.brunovaz.api_cursos.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunovaz.api_cursos.modules.course.CourseEntity;
import br.com.brunovaz.api_cursos.modules.course.Exceptions.CourseNotFoundException;
import br.com.brunovaz.api_cursos.modules.course.repository.CourseRepository;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity){
        this.courseRepository.findByName(courseEntity.getName()).ifPresent((course)->{
            throw new CourseNotFoundException();
        });
        return this.courseRepository.save(courseEntity);
    }
}
