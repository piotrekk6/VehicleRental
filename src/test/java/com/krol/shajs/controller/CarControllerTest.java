package com.krol.shajs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.krol.shajs.dto.CarDto;
import com.krol.shajs.enums_converters.Color;
import com.krol.shajs.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
@ContextConfiguration
public class CarControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    CarService carService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnCreatedStatusWhenAddedCar() throws Exception {
        CarDto carDto = new CarDto("Fast", Color.RED, LocalDate.parse("2010-01-01"), "Furious");
        String requestJson = objectMapper.writeValueAsString(carDto);

        mockMvc.perform(post("/api/addCar")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(requestJson)).andDo(print())
               .andExpect(status().isCreated());
        verify(carService).addCar(carDto);
    }

    @Test
    @WithMockUser
    public void shouldReturnOkStatusWhenAddedCarByManufacturer() throws Exception {
        String manufacturerName = "Daihatsu";

        mockMvc.perform(post("/api/addCar/{manufacturer}", manufacturerName))
               .andDo(print())
               .andExpect(status().isOk());
        verify(carService, Mockito.times(1)).addCar(manufacturerName);
    }
}
