package com.dss.backend;

import com.dss.backend.controller.FlowController;
import com.dss.backend.controller.SchoolController;
import com.dss.backend.controller.StudentController;
import com.dss.backend.model.School;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentSchoolTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HistoryService historyService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final StudentController studentController = new StudentController(runtimeService, historyService);
        final SchoolController schoolController = new SchoolController(runtimeService, historyService);
        final FlowController flowController = new FlowController(runtimeService, historyService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(studentController, schoolController, flowController).build();
    }

    @Test
    public void testBP() throws Exception {
        ResultActions result = this.mockMvc.perform(get("/api/{melicode}/findSchoolByMelicode", 1000));
        String json = result.andReturn().getResponse().getContentAsString();
        School school = new ObjectMapper().readValue(json, School.class);
        System.out.println("print: " + school);
    }
}
