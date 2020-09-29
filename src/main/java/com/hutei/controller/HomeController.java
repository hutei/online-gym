package com.hutei.controller;


import com.hutei.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String showSignInForm(Model model){

        User user = new User();

        model.addAttribute("user", User.class);

        return "/index";
    }

    @GetMapping("/aboutUs")
    public String showPage(){

        return "aboutUs";
    }


}
