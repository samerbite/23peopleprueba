package people.cl.service;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import people.cl.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Optional<Student>estudiandtesPorId(Long id);
    List<Student> listadoEstudiantes();
    Page<Student>listadoEstudiantesPaginas();
    ResponseEntity<Student>guardaEstudiante(Student student);
    ResponseEntity<Student>actualizaEstudiante(Long id, Student student);
    ResponseEntity<Student>eliminaEstudiante(Long id);
}
