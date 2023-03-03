package com.example.server.dto;

import com.example.server.model.Type;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {
    @NotEmpty
    private String type;

    @NotEmpty
    private String name;

    @NotNull
    private LocalDate limit_date;

    @NotNull
    @Min(0)
    private int estimated_duration;



}
