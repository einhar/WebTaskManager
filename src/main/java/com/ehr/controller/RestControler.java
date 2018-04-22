package com.ehr.controller;

import com.ehr.model.Task;
import com.ehr.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class RestControler {

    @Autowired
    private TaskService taskService;

    @GetMapping("/rest/hello")
    public String hello() {
        return "Hello World! by RestController";
    }

    @GetMapping("/rest/all-tasks")
    public String allTasks() {
        return taskService.findAll().toString();
    }

    @GetMapping("/rest/save-task")
    public String save(@RequestParam String name, @RequestParam String desc) {
        Task task = new Task(name, desc, new Date(), false);
        taskService.save(task);
        return "Task with id=" + task.getId() + " has been saved.";
    }

    @GetMapping("/rest/delete-task")
    public String delete(@RequestParam Integer id) {
        taskService.delete(id);
        return "Task with id=" + id + " has been deleted.";
    }

}
