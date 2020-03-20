package com.blove.space.taskJob;

import org.springframework.stereotype.Component;

@Component("taskDemo")
public class TaskDemo {

    public void taskWithParams(String params){
        System.out.println("执行有参定时任务示例:" + params);
    }

    public void taskNoParams(){
        System.out.println("执行无参定时任务示例");
    }
}
