package com.r2.spiral.functional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testPingController() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/ping")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("pong")));
    }

    @Test
    void testSpiral2rows2colsController() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/spiral?rows=2&cols=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"rows\":[[0,1],[2,1]]")));
    }

    @Test
    void testSpiral1rows4colsController() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/spiral?rows=1&cols=4")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"rows\":[[0,1,1,2]]")));
    }

    @Test
    void testSpiral4rows1colsController() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/spiral?rows=4&cols=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"rows\":[[0],[1],[1],[2]]")));
    }

    @Test
    void testSpiralControllerWithErrorCustomParams() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/spiral?rows=asd&cols=asd")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(equalTo("{\"message\":\"Query params must be numeric\"}")));
    }
}
