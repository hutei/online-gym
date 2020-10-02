package com.hutei.controller;

import com.hutei.Service.Exception.UserAlreadyExistException;
import com.hutei.Service.UserService;
import com.hutei.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/services")
    public String getTraining(){

        return "training";
    }

    @GetMapping("/signUp")
    public String signUp(Model model){

        UserDto userDto = new UserDto();

        model.addAttribute("userDto", userDto);

        return "registration";
    }

    @PostMapping("/signUp")
    public String userRegistration(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult bindingResult, Model model) {//<--------valid should be there and bindingResult

        model.addAttribute("userDto", userDto);



        if(bindingResult.hasErrors()){
            model.addAttribute("userDto", userDto);
            return "registration";
        }
        try {
            userService.register(userDto);
        }catch (UserAlreadyExistException e){
            bindingResult.rejectValue("email", "userDto.email","An account already exists for this email.");
            model.addAttribute("userDto", userDto);
            return "registration";
        }
        return "/index";//<------------------To change--------------------|||
    }





}
