package people.cl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import people.cl.model.Course;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long id);
    List<Course> findAll ();
    Page<Course> findAll (Pageable pageable);
    Course save(Course course);
    void deleteById (Long id);
    boolean existsById (Long id);

}
