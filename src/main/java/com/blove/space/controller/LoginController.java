package com.blove.space.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping("login")
    public ModelAndView goLogin(){
        System.out.println("-------------");
        return new ModelAndView("client/login/login");
    }

    @RequestMapping("index")
    public ModelAndView goindex(ModelMap map){
        map.put("dayNum","23");
        return new ModelAndView("client/home");
    }
}
