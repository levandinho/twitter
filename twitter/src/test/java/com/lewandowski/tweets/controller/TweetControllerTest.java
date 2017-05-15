package com.lewandowski.tweets.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lewandowski.commons.GlobalConstants;
import com.lewandowski.tweets.TweetTestConstants;
import com.lewandowski.tweets.dto.TweetDTO;
import com.lewandowski.tweets.service.TweetService;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.service.UserService;
import org.junit.Assert;
import org.junit.BeforeClass;
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

import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TweetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TweetService tweetService;

    @Autowired
    private UserService userService;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @BeforeClass
    public static void init() {
        objectMapper.setDateFormat(new SimpleDateFormat(GlobalConstants.DATE_FORMAT));
    }

    @Test
    public void should_save_tweet_given_correct_values() throws Exception {

        User user = new User("testUser");
        userService.addUser(user);

        TweetDTO tweetDTO = new TweetDTO(null, TweetTestConstants.MESSAGE, user.getId(), null);

        String URL = "/users/" + user.getId() + "/tweets/";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tweetDTO)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        TweetDTO result = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), TweetDTO.class);

        Assert.assertNotNull(result.getId());
        Assert.assertEquals(TweetTestConstants.MESSAGE, result.getMessage());
        Assert.assertEquals(user.getId(), result.getAuthorId());
    }

}
