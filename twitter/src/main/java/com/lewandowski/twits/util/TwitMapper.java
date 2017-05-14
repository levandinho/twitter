package com.lewandowski.twits.util;

import com.lewandowski.commons.Mapper;
import com.lewandowski.twits.dto.TwitDTO;
import com.lewandowski.twits.entity.Twit;
import org.springframework.stereotype.Component;


@Component
public class TwitMapper implements Mapper<Twit, TwitDTO>{
    @Override
    public Twit mapDtoToEntity(TwitDTO dto) {
        if (dto == null) {
            return null;
        }
        Twit twit = new Twit();
        twit.setId(dto.getId());
        twit.setMessage(dto.getMessage());
        return twit;
    }

    @Override
    public TwitDTO mapEntityToDto(Twit entity) {
        if (entity == null) {
            return null;
        }
        TwitDTO twitDTO = new TwitDTO(entity.getId(), entity.getMessage(), entity.getAuthor().getId(), entity.getDateAdded());
        return twitDTO;
    }
}
