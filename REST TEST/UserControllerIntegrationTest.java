package com.cts;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.entity.User;
import com.cts.repository.UserRepository;

//Spring Boot to start the embedded web server (e.g., Tomcat) on a random free port
//when running integration test.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    //Simulates real HTTP requests to test the controller indirectly
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
    	//Ensures test isolation and avoids data pollution between tests
        userRepository.deleteAll();

        userRepository.save(new User(null, "Shek", "shekjava@gmail.com"));
        userRepository.save(new User(null, "Vijay", "vijay@gmail.com"));
    }

    @Test
    void shouldReturnAllUsers() throws Exception {
        mockMvc.perform(get("/users/all"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.length()").value(2))
               .andExpect(jsonPath("$[0].username").value("Shek"))
               .andExpect(jsonPath("$[1].username").value("Vijay"));
    }
    
    @Test
    void shouldCreateNewUser() throws Exception {
        String newUserJson = """
            {
                "username": "Arjun",
                "email": "arjun@gmail.com"
            }
        """;

        mockMvc.perform(post("/users/save")
                .contentType("application/json")
                .content(newUserJson))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").exists())
               .andExpect(jsonPath("$.username").value("Arjun"))
               .andExpect(jsonPath("$.email").value("arjun@gmail.com"));
    }

    
    @Test
    void shouldDeleteUserById() throws Exception {
        User user = userRepository.save(new User(null, "Temp", "temp@gmail.com"));

        mockMvc.perform(delete("/users/" + user.getId()))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").value("User deleted successfully with ID: " + user.getId()));
    }

}
