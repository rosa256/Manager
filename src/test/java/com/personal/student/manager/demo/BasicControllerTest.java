package com.personal.student.manager.demo;

import com.personal.student.manager.demo.Controllers.BasicController;
import com.personal.student.manager.demo.Repository.IStudentRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class BasicControllerTest {

    @InjectMocks
    private BasicController basicController;

    @Mock
    private IStudentRepository studentRepository;

    @Test
    public void index() throws Exception {


        MockMvc mockMvc =
                standaloneSetup(basicController).build();

        mockMvc.perform(get("/"))
                .andExpect(view().name("index"));
        mockMvc.perform(get("/home"))
                .andExpect(view().name("index"));
//        mockMvc.perform(get("/index"))
//                .andExpect(view().name("index"));
    }
}
