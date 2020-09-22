package com.hutei.dto;

import com.hutei.entity.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserDto {

    private int id;
    private String username;
    private String password;
    private String email;
    private String sex;
    private String trainType;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.sex = user.getSex();
        this.trainType = user.getTrainType();
    }
}
