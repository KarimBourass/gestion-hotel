package com.ensa.service;


import com.ensa.beans.OptionChambre;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OptionChambreService.class)
@ActiveProfiles("test")
class OptionChambreServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    OptionChambreService optionChambreService;



    @Test
    public void get_allOptions_return0kWithListOfOptions() throws Exception {
        List<OptionChambre> OptionList = new ArrayList<>();

        OptionChambre option1 = new OptionChambre(1L,"TV");
        OptionChambre option2 = new OptionChambre(2L,"BED");

        OptionList.add(option1);
        OptionList.add(option2);

        Mockito.when(OptionChambreService.getAllOptions()).thenReturn(OptionList);

        mockMvc.perform(MockMvcRequestBuilders.get("/options").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void creerUneNouvelleOption() throws Exception {
        OptionChambre optionChambre = new OptionChambre(3L,"Breakfist");
        Mockito.when(OptionChambreService.save(Mockito.any())).thenReturn(optionChambre);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/options")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(this.mapper.writeValueAsBytes(optionChambre));
        mockMvc.perform(builder).andExpect(status().isCreated());
    }



    @Test
   public void deleteById() throws Exception {
        Long id = 1L;
        OptionChambreService optspy= Mockito.spy(optionChambreService);
        Mockito.doNothing().when(optspy).deleteById(id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/options/1")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());

    }

    @Test
    public void updateOption() throws Exception {
        OptionChambre optionChambre = new OptionChambre(12L,"Food");
        Mockito.when(OptionChambreService.updateOption(12L,optionChambre)).thenReturn(optionChambre);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .put("/options/15",optionChambre )
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(this.mapper.writeValueAsBytes(optionChambre));
        mockMvc.perform(builder).andExpect(status().isAccepted());
    }

}