package com.example.server.service;


import com.example.server.dto.TaskDTO;
import com.example.server.model.Task;
import com.example.server.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository repository;



    public Task saveTask(TaskDTO task){
        Task newTask = new Task();
        newTask.setName(task.getName());
        newTask.setEstimated_duration(task.getEstimated_duration());
        newTask.setType(task.getType());
        newTask.setLimit_date(task.getLimit_date());
        return repository.save(newTask);
    }

    public List<Task> getAll(){
        return repository.findAll();
    }

    public long deleteById(long id){
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return id;
        }
        return 0;
    }

    public Task getById(long id){

        return repository.findById(id).get();
    }


}

