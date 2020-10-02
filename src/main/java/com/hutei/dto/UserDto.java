package com.hutei.dto;

import com.hutei.annotation.FieldMatch;
import com.hutei.annotation.ValidEmail;
import com.hutei.annotation.ValidPassword;
import com.hutei.entity.User;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Component
@FieldMatch(first = "confirmPassword", second = "password", message = "The password fields must match")
public class UserDto {

    @NotEmpty(message = "can't be empty")
    @NotNull(message = "can't be empty")
    private String username;

    @NotEmpty(message = "can't be empty")
    @NotNull(message = "can't be empty")
    @ValidPassword
    private String password;

    @NotEmpty(message = "can't be empty")
    @NotNull(message = "can't be empty")
    private String confirmPassword;

    @ValidEmail(message = "invalid email")
    @NotEmpty(message = "can't be empty")
    @NotNull(message = "can't be empty")
    private String email;

    @NotEmpty(message = "can't be empty")
    @NotNull(message = "can't be empty")
    private String sex;

    @NotEmpty(message = "can't be empty")
    @NotNull(message = "can't be empty")
    private String trainType;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.sex = user.getSex();
        this.trainType = user.getTrainType();
    }

    public UserDto() {

    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }
}
