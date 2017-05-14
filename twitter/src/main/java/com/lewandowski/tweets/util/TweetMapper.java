package com.lewandowski.tweets.util;

import com.lewandowski.commons.Mapper;
import com.lewandowski.tweets.dto.TweetDTO;
import com.lewandowski.tweets.entity.Tweet;
import org.springframework.stereotype.Component;


@Component
public class TweetMapper implements Mapper<Tweet, TweetDTO>{
    @Override
    public Tweet mapDtoToEntity(TweetDTO dto) {
        if (dto == null) {
            return null;
        }
        Tweet tweet = new Tweet();
        tweet.setId(dto.getId());
        tweet.setMessage(dto.getMessage());
        return tweet;
    }

    @Override
    public TweetDTO mapEntityToDto(Tweet entity) {
        if (entity == null) {
            return null;
        }
        TweetDTO tweetDTO = new TweetDTO(entity.getId(), entity.getMessage(), entity.getAuthor().getId(), entity.getDateAdded());
        return tweetDTO;
    }
}
