package com.example.vaccinationmanagementsystem.controllers;

import com.example.vaccinationmanagementsystem.TestUtil;
import com.example.vaccinationmanagementsystem.representation.CitizenRepresentation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CitizenController.class)
class CitizenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    private CitizenRepresentation citizen;

    @BeforeEach
    public void setup() {
        citizen = TestUtil.createCitizen();
    }

    @Test
    public void whenEmailIsInvalidAnErrorTakesPlace() throws Exception {
        citizen.getPerson().setEmail("aaoo");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/citizen/sign-up")
                        .content(objectMapper.writeValueAsString(citizen))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", is(false)));
    }

    @Test
    public void whenEmailIsValidResponseIsSuccess() throws Exception {
        citizen.getPerson().setEmail("pepito@correo.com");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/citizen/sign-up")
                        .content(objectMapper.writeValueAsString(citizen))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(true)));
    }

    @Test
    public void whenEcuadorianIdIsInvalidAnErrorTakesPlace() throws Exception {
        citizen.getPerson().setId("1234567890");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/citizen/sign-up")
                        .content(objectMapper.writeValueAsString(citizen))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", is(false)));
    }

    @Test
    public void whenIsValidResponseIsSuccess() throws Exception {
        citizen.getPerson().setId("1757332018");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/citizen/sign-up")
                        .content(objectMapper.writeValueAsString(citizen))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(true)));
    }

    @Test
    public void whenFirstNameIsInvalidAnErrorTakesPlace() throws Exception {
        citizen.getPerson().setFirstName("pepe1");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/citizen/sign-up")
                        .content(objectMapper.writeValueAsString(citizen))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", is(false)));
    }

    @Test
    public void whenFirstIsValidResponseIsSuccess() throws Exception {
        citizen.getPerson().setFirstName("Pepe");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/citizen/sign-up")
                        .content(objectMapper.writeValueAsString(citizen))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(true)));
    }

    @Test
    public void whenFirstLastNameIsInvalidAnErrorTakesPlace() throws Exception {
        citizen.getPerson().setFirstName("pepe1");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/citizen/sign-up")
                        .content(objectMapper.writeValueAsString(citizen))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", is(false)));
    }

    @Test
    public void whenFirstLastNameIsValidResponseIsSuccess() throws Exception {
        citizen.getPerson().setFirstName("Pepe");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/citizen/sign-up")
                        .content(objectMapper.writeValueAsString(citizen))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(true)));
    }

    @Test
    public void whenSecondLastNameIsInvalidAnErrorTakesPlace() throws Exception {
        citizen.getPerson().setSecondLastName("pepe1");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/citizen/sign-up")
                        .content(objectMapper.writeValueAsString(citizen))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", is(false)));
    }

    @Test
    public void whenSecondLastNameIsValidResponseIsSuccess() throws Exception {
        citizen.getPerson().setSecondLastName("Pepe");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/citizen/sign-up")
                        .content(objectMapper.writeValueAsString(citizen))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(true)));
    }

}
