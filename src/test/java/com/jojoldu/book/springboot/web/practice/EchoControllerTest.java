package com.jojoldu.book.springboot.web.practice;

import org.junit.jupiter.api.Test;
// TODO: 필요한 import (Autowired, WebMvcTest, MockMvc, get, status, content)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EchoController.class)

public class EchoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void spring을_거꾸로_뒤집으면_gnirps() throws Exception {

        // TODO: GET /echo/spring 요청 → status 200 → content "gnirps" 검증
        mvc.perform(get("/echo/spring"))
                .andExpect(status().isOk())
                .andExpect(content().string("gnirps"));
    }

}
