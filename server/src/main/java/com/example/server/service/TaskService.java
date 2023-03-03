package com.example.server.service;


import com.example.server.dto.TaskDTO;
import com.example.server.exception.TaskNotFoundException;
import com.example.server.model.State;
import com.example.server.model.Task;
import com.example.server.model.Type;
import com.example.server.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
public class TaskService {
    private final TaskRepository repository;


    public Task saveTask(TaskDTO dto) {
        Task task = adaptTaskDTOtoTask(dto);
        log.trace("New task is saved");
        return repository.save(task);
    }

    public Task adaptTaskDTOtoTask(TaskDTO dto) {
        if (!validateDate(dto.getLimit_date())) {
            log.debug("Expiration date must be after today");
        }
        if(!validateType(dto.getType())){
            log.debug("Type is not conform");
            throw new IllegalArgumentException("Type is not conform");
        }
        Task newTask = new Task();
        newTask.setName(dto.getName());
        newTask.setEstimated_duration(dto.getEstimated_duration());
        newTask.setType(Type.valueOf(dto.getType()));
        newTask.setLimit_date(dto.getLimit_date());
        newTask.setCreation_date(LocalDate.now());
        newTask.setState(State.UNFINISHED);
        return newTask;
    }
    public boolean validateType(String type){
        if(type.toUpperCase(Locale.ROOT).equals(Type.HOBBY.name()) || type.toUpperCase(Locale.ROOT).equals(Type.HOME.name()) || type.toUpperCase(Locale.ROOT).equals(Type.WORK.name())){
            return true;
        }
        return false;
    }
    public boolean validateDate(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            log.debug("Expiration date must be after today");
            throw new IllegalArgumentException("Expiration date must be after today");
        }
        return true;
    }

    public List<Task> getAll() {
        List<Task> tasks = repository.getAllTasksInAscendingOrder();
        if (tasks.isEmpty()) {
            log.warn("There are no tasks found in the database");
        } else {
            log.debug("Retrieving all tasks");
        }
        return tasks;
    }

    public long deleteById(long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            log.debug("Task with id is found and deleted");
            return id;
        }
        throw new TaskNotFoundException(id);
    }

    public Task getById(long id) {
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }
    public List<Task> manageSort(String sort){
        if(!validateSort(sort))throw new IllegalArgumentException("Sort is not conform");
        if ("asc".equals(sort)) {
            return getAllTasksSortedAsc();
        } else {
            return getAllTasksDesc();
        }
    }
    public boolean validateSort(String sort){
        if(Objects.equals(sort, "asc") || Objects.equals(sort, "desc"))return true;
        return false;
    }
    public List<Task> getAllTasksSortedAsc(){
        return repository.getAllTasksInOrderOfExpirationDateAsc();
    }
    public List<Task> getAllTasksDesc(){
        return repository.getAllTasksInOrderOfExpirationDateDesc();
    }
}

