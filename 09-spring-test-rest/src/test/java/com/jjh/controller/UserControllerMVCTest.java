package com.jjh.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjh.domain.User;
import com.jjh.main.Application;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Testing a controller or rest controller via
 * the MVC infrastructure
 */
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class UserControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUserForJohnViaMVC() throws Exception {
        String urlTemplate = "/users/user/John";

        mockMvc.perform(get(urlTemplate))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("John")))
                .andExpect(content()
                        .string(containsString("54")));
    }

    @Test
    public void getTwoUsersListInJSON() throws Exception {
        String urlTemplate = "/users/list";
        mockMvc.perform(get(urlTemplate))
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("Bill")))
                .andExpect(content()
                        .string(containsString("Ben")));
    }

    @Test
    public void testAddingNewUserRequest() throws Exception {
        String url = "/users";
        User user = new User("4", "Denise", 53);
        mockMvc.perform(post(url)
                .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
