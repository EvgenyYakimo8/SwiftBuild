package by.swiftbuild;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SwiftBuildApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    /*private String obtainAccessToken() throws Exception {
        mockMvc.perform(post("/user/reg")
                        .content("{\"username\":\"testuser\", \"password\":\"testpassword\"}")
                        .contentType("application/json"))
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(post("/user/login")
                        .content("{\"username\":\"testuser\", \"password\":\"testpassword\"}")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        return extractToken(responseContent);
    }

    private String extractToken(String responseContent) {
        return responseContent.split(":")[1].replaceAll("[\"{}]", "").trim();
    }*/


    @Test
    @WithMockUser(username = "testuser", password = "testpassword", roles = "ADMIN")
    public void createTenWorks() throws Exception {
        //String token = obtainAccessToken();
        for (int i = 0; i <= 10; i++) {
            String newWorkJson = String.format(
                    "{\"name\":\"Entity %d\", \"description\": %d, \"cost\": %d}"
                    , i, i * 10, i * 100);

            mockMvc.perform(post("/work/save")
                            //.header("Authorization", "Bearer " + token)
                            .content(newWorkJson)
                            .contentType("application/json"))
                            .andExpect(status().isCreated());
        }
    }

}
