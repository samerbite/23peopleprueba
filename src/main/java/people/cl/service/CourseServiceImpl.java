package people.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import people.cl.model.Course;
import people.cl.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Optional<Course>buscarPorId(Long id){
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> buscarTodos() {
        return courseRepository.findAll();
    }

    @Override
    public Page<Course> buscarTodosPaginados(){
        Pageable pageable = PageRequest.of(0,10, Sort.by("name"));
        return courseRepository.findAll(pageable);
    }
    @Override
    public ResponseEntity<Course> guardarCurso (Course course){
        Course response = courseRepository.save(course);
        return new ResponseEntity<Course>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Course> actualizacion(Long id, Course course){
        course.setId(id);
        Course response = courseRepository.save(course);
        return new ResponseEntity<Course>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Course>eliminaCurso (Long id){
        if (!existe(id)){
            return new ResponseEntity("No existe registro", HttpStatus.NOT_FOUND);
        }else{
            courseRepository.deleteById(id);
            return new ResponseEntity("Registro eliminado", HttpStatus.OK);
        }
    }
    private boolean existe (Long id){
        return courseRepository.existsById(id);
    }
}
