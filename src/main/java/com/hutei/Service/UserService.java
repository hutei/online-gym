package com.hutei.Service;

import com.hutei.Service.Exception.PasswordMatchingException;
import com.hutei.Service.Exception.UserAlreadyExistException;
import com.hutei.dto.UserDto;
import com.hutei.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {

    public void register(UserDto userDto) throws UserAlreadyExistException;
    public boolean checkIfUserExist(String email);
}
