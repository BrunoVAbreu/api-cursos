package br.com.brunovaz.api_cursos.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunovaz.api_cursos.modules.course.CourseEntity;
import br.com.brunovaz.api_cursos.modules.course.Exceptions.CourseNotFoundException;
import br.com.brunovaz.api_cursos.modules.course.repository.CourseRepository;

@Service
public class PatchCourseUseCase {
        @Autowired
        private CourseRepository courseRepository;

        public String execute(UUID id){
            CourseEntity course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());

            if (course.getActive() == CourseEntity.EnumCourseActive.ACTIVE) {
                course.setActive(CourseEntity.EnumCourseActive.DISABLED);
                courseRepository.save(course); 
                return "Curso desativado";
            }else {
                course.setActive(CourseEntity.EnumCourseActive.ACTIVE);
                courseRepository.save(course); 
                return "Curso ativado";
            }

        }
}
