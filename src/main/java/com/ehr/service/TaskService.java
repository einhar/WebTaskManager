package com.ehr.service;

import com.ehr.dao.TaskRepository;
import com.ehr.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        for (Task task : taskRepository.findAll()) {
                tasks.add(task);
        }
        return tasks;
    }

    public Task findTask(Integer id) {
        return taskRepository.findById(id);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }
}
