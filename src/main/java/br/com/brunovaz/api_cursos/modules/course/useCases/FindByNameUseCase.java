package br.com.brunovaz.api_cursos.modules.course.useCases;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunovaz.api_cursos.modules.course.CourseEntity;
import br.com.brunovaz.api_cursos.modules.course.repository.CourseRepository;

@Service
public class FindByNameUseCase {
    @Autowired
    CourseRepository courseRepository;

    public Optional<CourseEntity> execute(String name){
        return this.courseRepository.findByName(name);
    }
}
