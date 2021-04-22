package com.covid.vaccinaton.centreLocator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class VaccinationCentreControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getVaccinationCentreTest() throws Exception {
        String inputString = "[ {\\r\\n    \\\"name\\\": \\\"Celinda Hamilton\\\",\\r\\n   \\\"age\\\": 39,\\r\\n    \\\"latitude\\\": \\\"53.542786433740105\\\",\\r\\n    \\\"longitude\\\": \\\"-9.585872216446724\\\"\\r\\n  }]";
        mockMvc.perform(post("/covid/vaccination/centre-details").content(inputString).contentType("application/json")).andDo(print()).andExpect(status().isOk());

    }
}
