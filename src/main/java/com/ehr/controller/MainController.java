package com.ehr.controller;


import com.ehr.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/all-tasks")
    public String allTasks(HttpServletRequest request) {
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return "index";
    }

    @GetMapping("/new-tasks")
    public String newTask(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @GetMapping("/update-tasks")
    public String updateTask(@RequestParam Integer id, HttpServletRequest request) {
        request.setAttribute("task", taskService.findTask(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }


}
