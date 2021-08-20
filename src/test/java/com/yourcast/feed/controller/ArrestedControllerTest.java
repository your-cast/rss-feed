package com.yourcast.feed.controller;

import com.yourcast.feed.models.dto.ArrestedDto;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.yourcast.feed.services.ArrestedServiceImpl;

@WebMvcTest
@Import({ArrestedController.class})
public class ArrestedControllerTest {
    public static final String API_ARREST_CHECK_URI = "/api/v1/arrests/{iban}";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ArrestedServiceImpl arrestedService;

    @Test
    void findArrestedByIban() throws Exception {
        String iban = "UA643003350000000002620214208";

        val expectedResponse = new ArrestedDto();
        doReturn(expectedResponse).when(arrestedService).findByIban(iban);

        mvc.perform(get(API_ARREST_CHECK_URI, iban)
                .contentType(APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON))
            .andExpect(jsonPath("$.arrested").value(false));
    }
}
