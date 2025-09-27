package br.com.brunovaz.api_cursos.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.brunovaz.api_cursos.modules.course.CourseEntity;
import br.com.brunovaz.api_cursos.modules.course.Exceptions.CourseNotFoundException;
import br.com.brunovaz.api_cursos.modules.course.repository.CourseRepository;

@Service
public class UpdateCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity, UUID id){
       CourseEntity course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());

       if ((courseEntity.getName() == null || courseEntity.getName().isEmpty()) 
            && (courseEntity.getCategory() !=null || !courseEntity.getCategory().isEmpty())) {
            course.setCategory(courseEntity.getCategory());
       } else if(courseEntity.getCategory() == null || courseEntity.getCategory().isEmpty()
                && (courseEntity.getName() !=null || !courseEntity.getName().isEmpty())){
            course.setName(courseEntity.getName());
       } else{
            course.setCategory(courseEntity.getCategory());
            course.setName(courseEntity.getName());
       }
        return courseRepository.save(course);
    }
}
