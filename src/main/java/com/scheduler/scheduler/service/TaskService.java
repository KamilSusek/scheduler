package com.scheduler.scheduler.service;

import com.scheduler.scheduler.dao.dtos.TaskDTO;
import com.scheduler.scheduler.dao.entities.Task;
import com.scheduler.scheduler.dao.repositories.TaskRepository;
import com.scheduler.scheduler.dao.repositories.TaskScheduleRepository;
import com.scheduler.scheduler.error.exceptions.ScheduleNotFoundException;
import com.scheduler.scheduler.error.exceptions.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private TaskScheduleRepository taskScheduleRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskScheduleRepository taskScheduleRepository) {
        this.taskRepository = taskRepository;
        this.taskScheduleRepository = taskScheduleRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task addTaskToSchedule(TaskDTO taskDTO, Long id) {
        return taskScheduleRepository.findById(id)
                .map(taskSchedule -> {
                    Task task = new Task(taskDTO.getTitle(), taskDTO.getDescription(), taskSchedule);
                    return taskRepository.save(task);
                })
                .orElseThrow(ScheduleNotFoundException::new);
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);

        taskRepository.delete(task);
    }

    public void setTaskCompleted(Long id) {
        taskRepository.findById(id)
                .map(task -> {
                    task.setCompleted(true);
                    return taskRepository.save(task);
                })
                .orElseThrow(TaskNotFoundException::new);
    }
}
