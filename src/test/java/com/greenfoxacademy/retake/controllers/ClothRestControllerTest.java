package com.greenfoxacademy.retake.controllers;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;;
import com.greenfoxacademy.retake.RetakeApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RetakeApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class ClothRestControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void price50_typeLower() throws Exception {

    float price = 50.0f;
    String type = "lower";

    mockMvc.perform(
            get("/warehouse/query?price=" + price + "&type=" + type)
    )
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(jsonPath("$.result", is("ok")))
            .andExpect(jsonPath("$.clothes").isNotEmpty())
            .andExpect(jsonPath("$.clothes[0].id", is(16)))
            .andExpect(jsonPath("$.clothes[0].manufacturer", is("Calvin Klein")))
            .andExpect(jsonPath("$.clothes[0].category", is("skirts")))
            .andExpect(jsonPath("$.clothes[0].size", is("s")))
            .andExpect(jsonPath("$.clothes[0].item_name", is("Strecth Steamed Pencil Skirt")))
            .andExpect(jsonPath("$.clothes[1].unit_price", is(39.0)))
            .andExpect(jsonPath("$.clothes[1].id", is(18)))
            .andExpect(jsonPath("$.clothes[1].manufacturer", is("Calvin Klein")))
            .andExpect(jsonPath("$.clothes[1].category", is("skirts")))
            .andExpect(jsonPath("$.clothes[1].size", is("m")))
            .andExpect(jsonPath("$.clothes[1].item_name", is("Strecth Steamed Pencil Skirt")))
            .andExpect(jsonPath("$.clothes[1].unit_price", is(39.0)));

  }

}