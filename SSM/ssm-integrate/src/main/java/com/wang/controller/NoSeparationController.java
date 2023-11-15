package com.wang.controller;

import com.wang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/noSeparation")
public class NoSeparationController {

    @RequestMapping("/getAll")
    public ModelAndView getAll(ModelAndView modelAndView){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1001,"小老虎","123456"));
        users.add(new User(1001,"长颈鹿","123456"));
        users.add(new User(1001,"河马","123456"));
        modelAndView.addObject("users", users);
        modelAndView.setViewName("noSeparation");
        return modelAndView;
    }
}

