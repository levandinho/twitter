package com.lewandowski.user.util;

import com.lewandowski.commons.Mapper;
import com.lewandowski.user.dto.UserDTO;
import com.lewandowski.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDTO> {

    @Override
    public User mapDtoToEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getName());
        return user;
    }

    @Override
    public UserDTO mapEntityToDto(User entity) {
        return new UserDTO(entity);
    }
}
