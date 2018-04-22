package com.ehr.controller;


import com.ehr.model.Task;
import com.ehr.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    private final String MAIN_PAGE = "index";

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return MAIN_PAGE;
    }

    @GetMapping("/all-tasks")
    public String allTasks(HttpServletRequest request) {
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return MAIN_PAGE;
    }

    @GetMapping("/new-task")
    public String newTask(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return MAIN_PAGE;
    }

    @PostMapping("/save-task")
    public String saveTask(@ModelAttribute Task task, HttpServletRequest request) {
        taskService.save(task);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return MAIN_PAGE;
    }

    @GetMapping("/update-task")
    public String updateTask(@RequestParam Integer id, HttpServletRequest request) {
        request.setAttribute("task", taskService.findTask(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return MAIN_PAGE;
    }

    @GetMapping("/delete-task")
    public String deleteTask(@RequestParam Integer id, HttpServletRequest request) {
        taskService.delete(id);
        request.setAttribute("tasks", taskService.findAll());
        request.setAttribute("mode", "MODE_TASKS");
        return MAIN_PAGE;
    }



}
