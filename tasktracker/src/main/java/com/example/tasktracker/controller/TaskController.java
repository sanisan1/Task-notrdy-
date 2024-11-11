package com.example.tasktracker.controller;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.model.User;
import com.example.tasktracker.service.TaskService;
import com.example.tasktracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(Authentication authentication) {
        User user = userService.findByUsername(authentication.getName()).orElseThrow();
        return ResponseEntity.ok(taskService.findTasksByUser(user));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task, Authentication authentication) {
        User user = userService.findByUsername(authentication.getName()).orElseThrow();
        task.setUser(user);
        return ResponseEntity.ok(taskService.createTask(task));
    }
}
