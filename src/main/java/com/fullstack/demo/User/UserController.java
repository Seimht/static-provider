package com.fullstack.demo.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    // Endpoint to show the login form
    @GetMapping("/login")
    public ModelAndView login(String error, String logout) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (error != null) {
            modelAndView.addObject("errorMsg", "Your username and password are invalid.");
        }
        if (logout != null) {
            modelAndView.addObject("msg", "You have been logged out successfully.");
        }
        return modelAndView;
    }
}
