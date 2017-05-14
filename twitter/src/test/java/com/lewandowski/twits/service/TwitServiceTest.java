package com.lewandowski.twits.service;

import com.lewandowski.twits.entity.Twit;
import com.lewandowski.twits.repository.TwitRepository;
import com.lewandowski.twits.service.impl.TwitServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.lewandowski.twits.TwitTestConstants.MESSAGE;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TwitServiceTest {

    @InjectMocks
    private TwitService twitService = new TwitServiceImpl();

    @Mock
    private TwitRepository twitRepository;

    @Test
    public void should_invoke_repository_when_saving() {
        Twit twit = new Twit();
        twit.setMessage(MESSAGE);

        twit = twitService.save(twit);

        verify(twitRepository, times(1)).save(any(Twit.class));
    }

    @Test
    public void verify_invoke_repository_when_getting_user_twits() {
        Long id = 1L;

        twitService.getTwitsForUser(id);

        verify(twitRepository, times(1)).findByAuthorIdOrderByDateAddedDesc(id);
    }
}
