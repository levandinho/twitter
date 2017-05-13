package com.lewandowski.twit.controller;

import com.lewandowski.twit.dto.TwitDTO;
import com.lewandowski.twit.entity.Twit;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class TwitCustomMapper extends CustomMapper<Twit, TwitDTO> {

    @Override
    public void mapAtoB(Twit twit, TwitDTO twitDTO, MappingContext context) {
        twitDTO.setAuthorId(twit.getAuthor().getId());
        twitDTO.setMessage(twit.getMessage());
        twitDTO.setId(twit.getId());
    }

    @Override
    public void mapBtoA(TwitDTO twitDTO, Twit twit, MappingContext mappingContext) {
    }

}
