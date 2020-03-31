package people.cl.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import people.cl.model.Course;
import people.cl.repository.CourseRepository;

import java.util.Optional;

public class CourseServiceImplTest {

    @InjectMocks
    private CourseServiceImpl courseServiceImpl;

    @Mock
    private CourseRepository courseRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void buscarPorIdTest (){
        Long id = 1L;
        Course response = Course.builder().build();
        Optional<Course> course = Optional.of(response);
        Mockito.doReturn(course).when(courseRepository).findById(Mockito.anyLong());
        Optional<Course>optional = courseServiceImpl.buscarPorId(id);
        Assert.assertNotNull(optional);
    }
}
