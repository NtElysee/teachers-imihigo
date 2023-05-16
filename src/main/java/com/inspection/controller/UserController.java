package com.inspection.controller;


import com.inspection.model.Teacher;
import com.inspection.model.User;
import com.inspection.repository.UserRepository;
import com.inspection.serviceLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

      @Autowired
      private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model)
    {
        model.addAttribute("registerRequest", new User());
        return "register_page";
    }


    @GetMapping("/login")
    public String getLoginPage(Model model)
    {
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("register Request" + user);
        User registeredUser=userService.registerUser(user.getLogin(), user.getPassword(), user.getEmail());
        return registeredUser== null ? "error_Page" : "redirect:/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        System.out.println("login Request" + user);
        User authenticated=userService.authenticate(user.getEmail(), user.getPassword());
        if (authenticated !=null) {

            model.addAttribute("teacher", new Teacher());
            return "teacher_form";
        }else{
            model.addAttribute("teacher", new Teacher());
            return "error_Page";
        }
    }

}

