package kakaopay.test.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestShortUrlController {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webContext;

    @Before
    public void setupTest() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
    }

    @Test
    public void testCreateShortUrl() throws Exception {
        MvcResult mockResult = mockMvc.perform(MockMvcRequestBuilders.post("/short-url")
                                                    .param("url", "www.naver.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String sJson = mockResult.getResponse().getContentAsString();

        System.out.println("result=" + sJson);
    }

}
