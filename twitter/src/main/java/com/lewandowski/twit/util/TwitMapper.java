package com.lewandowski.twit.util;

import com.lewandowski.commons.Mapper;
import com.lewandowski.twit.dto.TwitDTO;
import com.lewandowski.twit.entity.Twit;
import org.springframework.stereotype.Component;


@Component
public class TwitMapper implements Mapper<Twit, TwitDTO>{
    @Override
    public Twit mapDtoToEntity(TwitDTO dto) {
        Twit twit = new Twit();
        twit.setId(dto.getId());
        twit.setMessage(dto.getMessage());
        return twit;
    }

    @Override
    public TwitDTO mapEntityToDto(Twit entity) {
        TwitDTO twitDTO = new TwitDTO(entity.getId(), entity.getMessage(), entity.getAuthor().getId());
        return twitDTO;
    }
}
