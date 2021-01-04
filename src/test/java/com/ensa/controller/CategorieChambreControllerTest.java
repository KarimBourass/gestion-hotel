package com.ensa.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ensa.controller.CategorieChambreController;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CategorieChambreControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private CategorieChambreController cc;
	
	@Before
	public void setUp() throws Exception{
		mockMvc=MockMvcBuilders.standaloneSetup(cc).build();
	}
	
	@Test
	void test() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/categories/1"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
