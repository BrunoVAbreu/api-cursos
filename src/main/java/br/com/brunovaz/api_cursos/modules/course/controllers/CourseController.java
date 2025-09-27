package br.com.brunovaz.api_cursos.modules.course.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.brunovaz.api_cursos.modules.course.CourseEntity;
import br.com.brunovaz.api_cursos.modules.course.repository.CourseRepository;
import br.com.brunovaz.api_cursos.modules.course.useCases.CreateCourseUseCase;
import br.com.brunovaz.api_cursos.modules.course.useCases.FindByCategoryUseCase;
import br.com.brunovaz.api_cursos.modules.course.useCases.FindByNameAndCategoryUseCase;
import br.com.brunovaz.api_cursos.modules.course.useCases.FindByNameUseCase;
import br.com.brunovaz.api_cursos.modules.course.useCases.ListAllCoursesUseCase;


@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CreateCourseUseCase createCourseUseCase;

    @Autowired
    ListAllCoursesUseCase listAllCoursesUseCase;

    @Autowired
    FindByNameAndCategoryUseCase findByNameAndCategoryUseCase;

    @Autowired
    FindByCategoryUseCase findByCategoryUseCase;

    @Autowired
    FindByNameUseCase findByNameUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CourseEntity courseEntity){
        try{
           var result= this.createCourseUseCase.execute(courseEntity);
           return ResponseEntity.ok().body(result);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    
    @GetMapping("/")
    public ResponseEntity<Object> findCourses(@RequestParam(required = false)String name, @RequestParam(required = false)String category) {
        try{
            Optional<List<CourseEntity>> resultList = null;

            if(name==null && category==null){
                var list = this.listAllCoursesUseCase.execute();
                return ResponseEntity.ok().body(list);
            } else if(name!=null && category!=null){
                resultList = this.findByNameAndCategoryUseCase.execute(name, category);
            } else if (category!=null){
                resultList = this.findByCategoryUseCase.execute(category);
            }else {
                var result = this.findByNameUseCase.execute(name);
                return ResponseEntity.ok().body(result);
            }
            return ResponseEntity.ok().body(resultList);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }
    
}
