package com.hutei.Service;

import com.hutei.Service.Exception.UserAlreadyExistException;
import com.hutei.dao.UserRepository;
import com.hutei.dto.UserDto;
import com.hutei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

//    @Autowired
//    PasswordEncoder passwordEncoder;


    @Override
    public void register(UserDto userDto)throws UserAlreadyExistException{

//        Let's check if user already registered with us
        if(checkIfUserExist(userDto.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }

        else {
            User user = new User(userDto);
           // encodePassword(user, userDto);
            repository.save(user);
        }

    }
    @Override
    public boolean checkIfUserExist(String email) {
        return repository.findByEmail(email) !=null ? true : false;
    }

//    private void encodePassword(User user, UserDto userDto){
//     user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        user.setPassword(userDto.getPassword());
//    }
}
