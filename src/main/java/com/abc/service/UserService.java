package com.abc.service;

import java.util.List;

import com.abc.dto.UserDto;
import com.abc.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}