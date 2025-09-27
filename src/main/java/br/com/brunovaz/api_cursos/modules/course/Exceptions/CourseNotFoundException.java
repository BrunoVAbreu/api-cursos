package br.com.brunovaz.api_cursos.modules.course.Exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(){
        super("Curso não encontrado");
    }
    
}
