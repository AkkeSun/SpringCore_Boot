package com.example.boottest2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class MyControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext ctx;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }


    @Test
    public void paramTest() throws Exception {
        MultiValueMap<String, String> info = new LinkedMultiValueMap<>();
        info.add("a", "sun");
        info.add("b", String.valueOf(123));

        mockMvc.perform(get("/paramTest")
                        .params(info))
                .andExpect(status().isOk())
                .andExpect(view().name("paramTest"))
                .andExpect(model().attribute("model", "sun123"))
                .andDo(print());
    }


    @Test
    public void validationTest() throws Exception {
        MyDto dto = new MyDto();
        dto.setId(-1);

        mockMvc.perform(get("/validationTest")
                        .content(String.valueOf(dto)))
                .andDo(print());
    }

    @Test
    public void formatterTest() throws Exception {
        mockMvc.perform((get("/formatterTest/sun")))
                .andDo(print());
    }

    @Test
    public void aopTest() throws Exception {
        mockMvc.perform(get("/aopTest"))
                .andDo(print());
    }


}