package com.scheduler.scheduler.dao.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TaskSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "taskSchedule", cascade = CascadeType.ALL)
    private Set<Task> tasks;

    public TaskSchedule() {
        this.tasks = new HashSet<>();

    }

    public TaskSchedule(String title, String description) {
        this.title = title;
        this.description = description;
        this.tasks = new HashSet<>();

    }

    public TaskSchedule(String title, String description, Set<Task> tasks) {
        this.title = title;
        this.description = description;
        this.tasks = tasks;
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

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
}
