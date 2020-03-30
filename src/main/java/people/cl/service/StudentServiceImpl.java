package people.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import people.cl.configuration.ErroresConfiguration;
import people.cl.model.Student;
import people.cl.repository.StudentReposiroty;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentReposiroty studentRepository;
    @Autowired
    private ErroresConfiguration erroresConfiguration;

    @Override
    public Optional<Student>estudiandtesPorId(Long id){
        return studentRepository.findById(id);
    }
    @Override
    public List<Student>listadoEstudiantes(){
        return studentRepository.findAll();
    }

    @Override
    public Page<Student>listadoEstudiantesPaginas(){
        Pageable page = PageRequest.of(0, 10, Sort.by("name"));
        return studentRepository.findAll(page);
    }

    @Override
    public ResponseEntity<Student>guardaEstudiante (Student student){
        if (student.getRut() == null||student.getName()==null||student.getLastname()==null||
        student.getAge()==null||student.getCourse()==null){
            return new ResponseEntity(erroresConfiguration.getCamposNulos(), HttpStatus.BAD_REQUEST);
        }
        if (student.getRut().equals("")||student.getName().equals("")||student.getLastname().equals("")||
        student.getAge().equals("")||student.getCourse().equals("")){
            return new ResponseEntity(erroresConfiguration.getCamposVacios(), HttpStatus.BAD_REQUEST);
        }
        Student responde = studentRepository.save(student);
        return new ResponseEntity<>(responde, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Student>actualizaEstudiante (Long id, Student student){
        student.setId(id);
        if (student.getRut() == null||student.getName()==null||student.getLastname()==null||
                student.getAge()==null||student.getCourse()==null){
            return new ResponseEntity(erroresConfiguration.getCamposNulos(), HttpStatus.BAD_REQUEST);
        }
        if (student.getRut().equals("")||student.getName().equals("")||student.getLastname().equals("")||
                student.getAge().equals("")||student.getCourse().equals("")){
            return new ResponseEntity(erroresConfiguration.getCamposVacios(), HttpStatus.BAD_REQUEST);
        }
        Student response = studentRepository.save(student);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Student>eliminaEstudiante (Long id){
        if (!existe(id)){
            return new ResponseEntity(erroresConfiguration.getRegistroNoExiste(), HttpStatus.NOT_FOUND);
        }else{
            studentRepository.deleteById(id);
            return new ResponseEntity("Registro eliminado", HttpStatus.OK);
        }
    }

    private boolean existe (Long id){
        return studentRepository.existsById(id);
    }

}
