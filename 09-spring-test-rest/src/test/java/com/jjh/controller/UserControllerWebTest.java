package com.jjh.controller;

import com.jjh.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing a Controller or Rest Controller by starting up
 * an embedded test application server and invoking services
 * via a rest template.
 */
@SpringBootTest(
        classes = com.jjh.main.Application.class,
        webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerWebTest {
    @Value("${local.server.port}") // Calculated by above WebEnvironment.RANDOM_PORT
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getUserInJSONFormatForJohn() {
        String url = "http://localhost:" + port + "/users/user/John";
        System.out.println(url);
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
        assertThat(response).contains("John");
        assertThat(response).contains("54");
    }

    @Test
    public void getUsersShouldReturnJSONListOfUser() {
        String url = "http://localhost:" + port + "/users/list";
        String response = restTemplate.getForObject(url, String.class);
        assertThat(response).contains("Bill");
        assertThat(response).contains("Ben");
    }

    @Test
    public void testAddingNewUser() {
        String url = "http://localhost:" + port + "/users";
        User user = new User("4", "Denise", 53);
        HttpEntity<User> request = new HttpEntity<>(user);
        ResponseEntity<String> response =
                this.restTemplate
                        .postForEntity(url, request, String.class);
        assertThat(response.toString()).contains("201");
    }

}
