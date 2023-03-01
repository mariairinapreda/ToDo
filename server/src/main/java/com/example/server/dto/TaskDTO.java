package com.example.server.dto;

import com.example.server.model.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {
    @NonNull
    private Type type;

    @NonNull
    private String name;

    @NonNull
    private Date limit_date;

    @NonNull
    private Date creation_date;

    @NonNull
    private int estimated_duration;



}
