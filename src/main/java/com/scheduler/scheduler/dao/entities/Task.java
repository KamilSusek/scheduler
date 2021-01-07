package com.scheduler.scheduler.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "is_completed", nullable = false)
    private Boolean isCompleted;

    @ManyToOne
    @JsonIgnore
    private TaskSchedule taskSchedule;

    public Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
    }

    public Task(String title, String description, TaskSchedule taskSchedule) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
        this.taskSchedule = taskSchedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public TaskSchedule getTaskSchedule() {
        return taskSchedule;
    }

    public void setTaskSchedule(TaskSchedule taskSchedule) {
        this.taskSchedule = taskSchedule;
    }
}
