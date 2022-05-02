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
    void testSpiral3rows5colsController() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/spiral?rows=3&cols=5")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"rows\":[[0,1,1,2,3],[89,144,233,377,5],[55,34,21,13,8]]")));
    }

    @Test
    void testSpiral5rows5colsController() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/spiral?rows=5&cols=5")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"rows\":[[0,1,1,2,3],[610,987,1597,2584,5],[377,28657,46368,4181,8],[233,17711,10946,6765,13],[144,89,55,34,21]]")));
    }

    @Test
    void testSpiralControllerWithStringCustomParams() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/spiral?rows=asd&cols=asd")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(equalTo("{\"message\":\"Query params must be numeric\"}")));
    }

    @Test
    void testSpiralControllerWithXLessThanZeroCustomParams() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/spiral?rows=3&cols=0")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(equalTo("{\"message\":\"Cols and rows must be > 0\"}")));
    }

    @Test
    void testSpiralControllerWithYLessThanZeroCustomParams() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/spiral?rows=0&cols=3")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(equalTo("{\"message\":\"Cols and rows must be > 0\"}")));
    }
}
