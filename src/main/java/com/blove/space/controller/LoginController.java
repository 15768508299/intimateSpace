package com.blove.space.controller;

import com.blove.space.common.DateUtil;
import com.blove.space.common.SysJobStatus;
import com.blove.space.model.SysJobpo;
import com.blove.space.service.JobPoService;
import javafx.print.PrinterJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    JobPoService jobPoService;

    @RequestMapping("/")
    public ModelAndView showHome(){
        return new ModelAndView("client/login/login");
    }

    @RequestMapping("login")
    public ModelAndView goLogin(){
        System.out.println("-------------");
        return new ModelAndView("client/login/login");
    }

    @RequestMapping("index")
    public ModelAndView goindex(ModelMap map){
        map.put("dayNum","23");
        SysJobpo jobpo = new SysJobpo();
        jobpo.setBeanname("taskDemo");
        jobpo.setMethodname("taskWithParams");
        jobpo.setMethodparams("66666");
        jobpo.setCronexpression("*/10 * * * * ?");
        jobpo.setCreatedat(DateUtil.currentTime());
        jobpo.setUpdatedat(0);
        jobpo.setJobstatus((byte)SysJobStatus.NORMAL.ordinal());
        jobPoService.insertJop(jobpo);
        return new ModelAndView("client/home");
    }
}
