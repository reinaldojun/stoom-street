package com.register.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.register.model.Street;
import com.register.service.StreetService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StreetControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private StreetService streetService;
 
    @Test
    public void incluir() throws Exception {
    	
       Street street = Street.builder().streetName("Teste").build();

       mockMvc.perform(post("/street")
    	                    .content(new Gson().toJson(street))
    	                    .contentType(MediaType.APPLICATION_JSON))
                            .andExpect(status().isCreated());
       
    }
    
    @Test
    public void alterar() throws Exception {
    	
        Street street = Street.builder().streetName("Teste").build();
    	Optional<Street> optional = Optional.of(street);
        given(streetService.findById(1L)).willReturn(optional);

        mockMvc.perform(put("/street/1")
     	                    .content(new Gson().toJson(street))
     	                    .contentType(MediaType.APPLICATION_JSON))
                             .andExpect(status().isOk());
       
    }
    
    @Test
    public void excluir() throws Exception {
    	
       Street street = Street.builder().streetName("Teste").build();
   	   Optional<Street> optional = Optional.of(street);
       given(streetService.findById(1L)).willReturn(optional);
        
       mockMvc.perform(delete("/street/1")
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk());
    }

    @Test
    public void listar() throws Exception {
    	
       Street street = Street.builder().streetName("Teste").build();
   	   Optional<Street> optional = Optional.of(street);
       given(streetService.findById(1L)).willReturn(optional);
        
       mockMvc.perform(get("/street/1")
              .accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk());
    }
    
    
    
}
    

