package com.example.server.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table
public class Task {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;

    @Column(name = "type", nullable = false)
    private Type type;

    @Column(name = "task_name", nullable = false)
    private String name;

    @Column(name = "limit_date", nullable = false)
    private Date limit_date;

    @Column(name = "creation_date", nullable = false)
    private Date creation_date;


    @Column(name = "estimated_duration", nullable = false)
    private int estimated_duration;

    @Builder.Default
    private int duration=0;

    @Builder.Default
    private State state = State.UNFINISHED;


}
