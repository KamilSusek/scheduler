package com.scheduler.scheduler.dao.dtos;

import java.util.List;

public class TaskScheduleDTO {
    private String title;
    private String description;
    private List<TaskDTO> tasks;

    public TaskScheduleDTO() {
    }

    public TaskScheduleDTO(String title, String description, List<TaskDTO> tasks) {
        this.title = title;
        this.description = description;
        this.tasks = tasks;
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

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}
