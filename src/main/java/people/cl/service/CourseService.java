package people.cl.service;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import people.cl.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
     Optional <Course> buscarPorId (Long id);
     List<Course> buscarTodos();
     Page<Course> buscarTodosPaginados();
     ResponseEntity<Course> guardarCurso (Course course);
     ResponseEntity<Course> actualizacion (Long id, Course course);
     ResponseEntity<Course> eliminaCurso (Long id);
}
