package com.hutei.controller;

import com.hutei.dao.SportsmanRepository;
import com.hutei.dto.UserDto;
import com.hutei.entity.User;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SportsmanRepository repository;

    @GetMapping("/showSignUpForm")
    public String showSignUpForm(Model model){

        User user = new User();

        model.addAttribute("user", User.class);

        return "sign-up-form";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("User") User user){

        String sex = user.getSex();
        String trainType = user.getTrainType();

        repository.save(user);

        return null;
    }

    @GetMapping("/showSignInForm")
    public String showSignInForm(Model model){

        User user = new User();

        model.addAttribute("user", User.class);

        return "sign-in-form";
    }

    @GetMapping("/signIn")
    public String authorization(@ModelAttribute("User") User user) throws NotFoundException {


        User dbUser = repository.findByUsername(user.getUsername());

        if(dbUser != null && dbUser.getUsername().equals(user.getUsername())
        && dbUser.getPassword().equals(user.getPassword())){

            if(dbUser.getSex().equals("male")){

                if(dbUser.getTrainType().equals("burning fat")){

                    return "MaleBurnFatTraining";
                }else return "MaleGainMassTraining";

            }else{
                if(dbUser.getTrainType().equals("burning fat")){

                    return "FemaleBurnFatTraining";
                }else return "FemaleGainMassTraining";
            }


        }else return "signInWithError";
    }

}
