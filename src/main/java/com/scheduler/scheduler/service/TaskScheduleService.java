package com.scheduler.scheduler.service;

import com.scheduler.scheduler.dao.dtos.TaskScheduleDTO;
import com.scheduler.scheduler.dao.entities.Task;
import com.scheduler.scheduler.dao.entities.TaskSchedule;
import com.scheduler.scheduler.dao.repositories.TaskRepository;
import com.scheduler.scheduler.dao.repositories.TaskScheduleRepository;
import com.scheduler.scheduler.error.exceptions.ScheduleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskScheduleService {

    private TaskRepository taskRepository;
    private TaskScheduleRepository taskScheduleRepository;

    @Autowired
    public TaskScheduleService(TaskRepository taskRepository, TaskScheduleRepository taskScheduleRepository) {
        this.taskRepository = taskRepository;
        this.taskScheduleRepository = taskScheduleRepository;
        initializeDB();
    }

    public List<TaskSchedule> findAllSchedules() {
        return taskScheduleRepository.findAll();
    }

    public TaskSchedule findScheduleByTitle(String title) {
        return taskScheduleRepository
                .findByTitle(title)
                .orElseThrow(ScheduleNotFoundException::new);
    }

    public TaskSchedule findScheduleById(Long id) {
        return taskScheduleRepository
                .findById(id)
                .orElseThrow(ScheduleNotFoundException::new);
    }

    public TaskSchedule addSchedule(TaskScheduleDTO taskScheduleDTO) {
        TaskSchedule taskSchedule = new TaskSchedule(taskScheduleDTO.getTitle(), taskScheduleDTO.getDescription());

        taskScheduleRepository.save(taskSchedule);

        taskScheduleDTO.getTasks().forEach(taskDTO -> {
            Task task = new Task(taskDTO.getTitle(), taskDTO.getDescription(), taskSchedule);
            taskRepository.save(task);
        });

        return taskSchedule;
    }

    public void delete(Long id) {
        TaskSchedule taskSchedule = taskScheduleRepository.findById(id)
                .orElseThrow(ScheduleNotFoundException::new);

        taskScheduleRepository.delete(taskSchedule);
    }

    private void initializeDB() {
        TaskSchedule taskSchedule = new TaskSchedule("Learn Java", "description");

        Task task0 = new Task("Learn Java's lamba function.", "description");
        Task task1 = new Task("Learn multithreading", "description1");
        Task task2 = new Task("Learn OOP in Java", "description2");


        List<Task> array = new ArrayList<>();

        array.add(task0);
        array.add(task1);
        array.add(task2);

        taskScheduleRepository.save(taskSchedule);
        task0.setTaskSchedule(taskSchedule);
        task1.setTaskSchedule(taskSchedule);
        task2.setTaskSchedule(taskSchedule);

        taskRepository.save(task0);
        taskRepository.save(task1);
        taskRepository.save(task2);

        TaskSchedule taskSchedule1 = new TaskSchedule("Learn TS", "description");

        Task task00 = new Task("Learn TS.", "description");
        Task task11 = new Task("Learn multithreading", "description1");
        Task task22 = new Task("Learn OOP in TS", "description2");

        List<Task> array1 = new ArrayList<>();

        array1.add(task00);
        array1.add(task11);
        array1.add(task22);

        taskScheduleRepository.save(taskSchedule1);
        task00.setTaskSchedule(taskSchedule1);
        task11.setTaskSchedule(taskSchedule1);
        task22.setTaskSchedule(taskSchedule1);

        taskRepository.save(task00);
        taskRepository.save(task11);
        taskRepository.save(task22);
    }

}
