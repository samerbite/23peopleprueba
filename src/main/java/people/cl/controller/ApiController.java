package people.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import people.cl.model.Course;
import people.cl.service.CourseService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/23people/api")
public class ApiController {
    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/courses/all")
    public ResponseEntity<Course>getAllCourses(){
        List<Course>course = courseService.buscarTodos();
        if(!course.isEmpty()){
            return new ResponseEntity(course, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<Course>getById(@PathVariable ("id") Long id){
        Optional<Course>course=courseService.buscarPorId(id);
        if (course.isPresent()){
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/courses")
    public ResponseEntity<Course>getAllCoursesPaginados(){
        Page<Course> course = courseService.buscarTodosPaginados();
        if(!course.isEmpty()){
            return new ResponseEntity(course, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(value = "/courses/guardacurso")
    public ResponseEntity<Course>saveCourse(@Valid @RequestBody Course course){
        courseService.guardarCurso(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @PutMapping(value = "/courses/actualizacion/{id}")
    public ResponseEntity<Course>update(@Valid @RequestBody Course course, @PathVariable("id") Long id){
        courseService.actualizacion(id, course);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @DeleteMapping(value = "/courses/elimina/{id}")
        public ResponseEntity<Course> eraseId (@PathVariable ("id") Long id){
            return courseService.eliminaCurso(id);
        }
}
