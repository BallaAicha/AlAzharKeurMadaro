package org.etutoria.alazhar.mapper;

import org.etutoria.alazhar.dto.UserDto;
import org.etutoria.alazhar.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDto fromUser(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public User fromUserDto(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
}