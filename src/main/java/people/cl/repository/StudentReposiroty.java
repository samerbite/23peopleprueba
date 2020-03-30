package people.cl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import people.cl.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentReposiroty extends JpaRepository<Student, Long> {
    Optional<Student> findById(Long id);
    List<Student> findAll ();
    Page<Student> findAll (Pageable pageable);
    Student save(Student student);
    void deleteById (Long id);
    boolean existsById (Long id);
}
