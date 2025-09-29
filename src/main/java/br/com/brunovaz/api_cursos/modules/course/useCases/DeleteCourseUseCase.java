package br.com.brunovaz.api_cursos.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunovaz.api_cursos.modules.course.Exceptions.CourseNotFoundException;
import br.com.brunovaz.api_cursos.modules.course.repository.CourseRepository;

@Service

public class DeleteCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID id){
        boolean courseExist = this.courseRepository.findById(id).isPresent();

        if(courseExist){
            this.courseRepository.deleteById(id);
        } else{
            throw new CourseNotFoundException();
        }
    }

}
