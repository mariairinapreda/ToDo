package com.example.server.exception;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(Long id){
        super(String.format("Task with id equal to %d was not found", id));
    }
}
