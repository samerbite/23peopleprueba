package people.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import people.cl.model.Course;
import people.cl.model.Student;
import people.cl.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/23people/api", headers = {
        "Content-Type=application/json",
        "Accept=application/json"
})
public class StudentsController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students/all")
    public ResponseEntity<Student> getAllStudents(){
        List<Student> students = studentService.listadoEstudiantes();
        if(!students.isEmpty()){
            return new ResponseEntity(students, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Course>getById(@PathVariable("id") Long id){
        Optional<Student> students=studentService.estudiandtesPorId(id);
        if (students.isPresent()){
            return new ResponseEntity(students.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/students")
    public ResponseEntity<Course>getAllStudentsPaginados(){
        Page<Student> students = studentService.listadoEstudiantesPaginas();
        if(!students.isEmpty()){
            return new ResponseEntity(students, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(value = "/students/guardaestudiantes")
    public ResponseEntity<Student>saveStudents(@Valid @RequestBody Student student){
        ResponseEntity<Student> response = studentService.guardaEstudiante(student);
        return response;
    }

    @PutMapping(value = "/students/actualizacion/{id}")
    public ResponseEntity<Student>update(@Valid @RequestBody Student student, @PathVariable("id") Long id){
        ResponseEntity<Student> response =studentService.actualizaEstudiante(id, student);
        return response;
    }

    @DeleteMapping(value = "/students/elimina/{id}")
    public ResponseEntity<Student> eraseId (@PathVariable ("id") Long id){
        return studentService.eliminaEstudiante(id);
    }
}
