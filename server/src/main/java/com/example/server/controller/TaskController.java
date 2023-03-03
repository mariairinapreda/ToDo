package com.example.server.controller;

import com.example.server.dto.TaskDTO;
import com.example.server.model.Task;
import com.example.server.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;



    @PostMapping()
    public void addTask(@RequestBody @Valid TaskDTO task){
         taskService.saveTask(task);
    }

    @DeleteMapping("/{id}")
    public long delete(@PathVariable("id")String id){
        System.out.println(id);
        return taskService.deleteById(Long.parseLong(id));
    }

    @GetMapping()
    public List<Task> getAllTasks(){
        return taskService.getAll();
    }



}
