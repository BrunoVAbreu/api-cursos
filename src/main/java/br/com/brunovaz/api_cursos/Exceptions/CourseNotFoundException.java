package br.com.brunovaz.api_cursos.Exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(){
        super("Curso não encontrado");
    }
    
}
