package com.personal.student.manager.demo;

import com.personal.student.manager.demo.Controllers.StudentController;
import com.personal.student.manager.demo.Repository.IStudentRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class StudentsControllerTest {
    @Test
    public void returnRegisterForm() throws Exception {
        IStudentRepository mockStudentRepository =
                mock(IStudentRepository.class);

        StudentController studentController = new StudentController(mockStudentRepository);

        MockMvc mockMvc = standaloneSetup(studentController).build();
        mockMvc.perform(get("/students/register"))
                .andExpect(view().name("registerForm"))
        .andExpect(status().isOk());
    }

    //Test zwracajacy N studentow, tak srednio dziala
    /*@Test
    public void shouldReturnLastNAddedStudents() throws Exception{
        List<Student> expectedStudents = createStudents(20);
        IStudentRepository mockRepository =
                mock(IStudentRepository.class);
        when(mockRepository.findTopByIdBefore(20))
                .thenReturn(expectedStudents);

        StudentController studentController = new StudentController(mockRepository);
        MockMvc mockMvc = standaloneSetup(studentController)
                .setSingleView(
                        new InternalResourceView("WEB-INF/views/students.jsp")
                ).build();

        mockMvc.perform(get("/students"))
                .andExpect(view().name("students"))
                .andExpect(model().attributeExists("studentsList"))
                .andExpect(model().attribute("students",hasItems(expectedStudents.toArray())));
    }

    private List<Student> createStudents(int count) {
        List<Student> myStudents = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            myStudents.add(new Student("Student"+i,"Surname"+i,(18+i)/2));
        }
        return myStudents;
    }*/
}
