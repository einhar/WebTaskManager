package com.ehr.controller;

import com.ehr.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControler {

    @Autowired
    private TaskService taskService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World! by RestController";
    }

    @GetMapping("/select-all")
    public String allTasks() {
        return taskService.findAll().toString();
    }
}
