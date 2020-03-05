package com.blove.space.Controller;

import org.springframework.stereotype.Controller;
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
}
