package com.example.server.repository;

import com.example.server.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>{
    @Query(value = "SELECT * FROM task  ORDER BY creation_date ASC ", nativeQuery = true)
    List<Task> getAllTasksInAscendingOrder();


    @Query(value = "SELECT * FROM task ORDER BY limit_date ", nativeQuery = true)
    List<Task> getAllTasksInOrderOfExpirationDateAsc();

    @Query(value = "SELECT * FROM task ORDER BY limit_date DESC ", nativeQuery = true)
    List<Task> getAllTasksInOrderOfExpirationDateDesc();

}
