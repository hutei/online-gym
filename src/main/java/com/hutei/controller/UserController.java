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

    @GetMapping("/signUp")
    public String signUp(Model model){

        UserDto user = new UserDto();

        model.addAttribute("user", user);

        return "signUp";
    }

    @PostMapping("/signUp")
    public String userRegistration(final @Valid UserDto userDto, final BindingResult bindingResult, final Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("userDto", userDto);
            return "signUp";
        }
        try {
            userService.register(userDto);
        }catch (UserAlreadyExistException e){
            bindingResult.rejectValue("email", "userDto.email","An account already exists for this email.");
            model.addAttribute("userDto", userDto);
            return "/signUp";
        }
        return "/index";//<------------------To change--------------------|||
    }

//    @PostMapping("/saveUser")
//    public String saveUser(@ModelAttribute("user") User user){
//
//        String sex = user.getSex();
//        String trainType = user.getTrainType();
//
//        repository.save(user);
//
//        return "/html/index";
//    }



//    @GetMapping("/signIn")
//    public String authorization(@ModelAttribute("User") User user) throws NotFoundException {
//
//
//        User dbUser = repository.findByUsername(user.getUsername());
//
//        if(dbUser != null && dbUser.getUsername().equals(user.getUsername())
//        && dbUser.getPassword().equals(user.getPassword())){
//
//            if(dbUser.getSex().equals("male")){
//
//                if(dbUser.getTrainType().equals("burning fat")){
//
//                    return "MaleBurnFatTraining";
//                }else return "MaleGainMassTraining";
//
//            }else{
//                if(dbUser.getTrainType().equals("burning fat")){
//
//                    return "FemaleBurnFatTraining";
//                }else return "FemaleGainMassTraining";
//            }
//
//
//        }else return "signInWithError";
//    }

}
