package com.clientes.controller;

import com.clientes.dto.ClientDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @Order(1)
    @Disabled
    void testFindAll() throws Exception{
        mvc.perform(get("/api/v1/client")).andDo(print());
    }

    @Test
    @Disabled
    void save() throws Exception{

        ClientDTO client = new ClientDTO();
        client.setName("Jonathan");
        client.setLastname("Huaman");
        client.setAddress("Av. Ricardo Palma 680");
        client.setEmail("jonathanhuaman94@gmail.com");
        client.setPhone("935865647");
        client.setStatus("active");

        String requestJson = new ObjectMapper().writeValueAsString(client);
        System.out.println("imrimiendo el json: "+requestJson);

        mvc.perform(post("/api/v1/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
