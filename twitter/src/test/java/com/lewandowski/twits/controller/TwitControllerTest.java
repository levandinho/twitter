package com.lewandowski.twits.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lewandowski.commons.exceptions.ErrorDTO;
import com.lewandowski.twits.TwitTestConstants;
import com.lewandowski.twits.dto.TwitDTO;
import com.lewandowski.twits.entity.Twit;
import com.lewandowski.twits.service.TwitService;
import com.lewandowski.users.dto.RegisterDTO;
import com.lewandowski.users.dto.UserDTO;
import com.lewandowski.users.repository.UserTestConstants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TwitControllerTest {

    private static final String REGISTER_AND_ADD = "/users/new/twits";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TwitService twitService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void should_register_a_new_user_and_add_a_new_twit() throws Exception {
        RegisterDTO registerDTO = new RegisterDTO(UserTestConstants.USERNAME, new TwitDTO(null, TwitTestConstants.MESSAGE, null, null));

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(REGISTER_AND_ADD)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerDTO)))
                .andExpect(status().is2xxSuccessful()).andReturn();
        UserDTO userDTO = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), UserDTO.class);

        Assert.assertNotNull(userDTO.getId());
        Assert.assertEquals(UserTestConstants.USERNAME,userDTO.getUsername());

        List<Twit> twits = twitService.getTwitsForUser(userDTO.getId());

        Assert.assertNotNull(twits);
        Assert.assertTrue(twits.size() == 1);
        Assert.assertEquals(TwitTestConstants.MESSAGE, twits.get(0).getMessage());
    }

    @Test
    public void should_return_error_when_user_with_id_doesnt_exist() throws Exception {

        Long badUserId = 111L;

        TwitDTO twitDTO = new TwitDTO(null, TwitTestConstants.MESSAGE, null, null);
        String saveUrl = "/users/" + badUserId + "/twits/";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(saveUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(twitDTO)))
                .andExpect(status().is5xxServerError()).andReturn();
        ErrorDTO errorDTO = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ErrorDTO.class);

        Assert.assertTrue(errorDTO.getMessage().contains(badUserId.toString()));
    }
}
