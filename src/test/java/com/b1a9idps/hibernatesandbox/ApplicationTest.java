package com.b1a9idps.hibernatesandbox;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.b1a9idps.hibernatesandbox.dto.request.UserCreateRequest;
import com.b1a9idps.hibernatesandbox.enums.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
@AutoConfigureMockMvc
class ApplicationTest {

    @Test
    void test(@Autowired MockMvc mvc, @Autowired ObjectMapper mapper) throws Exception {
        var createRequest = new UserCreateRequest("Ryosuke Uchitate", Gender.MAN, 31);
        mvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(createRequest)))
                        .andExpect(status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk());
    }

}
