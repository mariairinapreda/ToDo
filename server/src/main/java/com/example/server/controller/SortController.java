package com.example.server.controller;

import com.example.server.model.Task;
import com.example.server.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks/sort")
public class SortController {
    private final TaskService taskService;


    @GetMapping("/{param}")
    public List<Task> getAllAsc(@PathVariable("param")String param){
        return taskService.manageSort(param);
    }

}
