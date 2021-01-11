package com.scheduler.scheduler.controller;

import com.scheduler.scheduler.dao.dtos.TaskDTO;
import com.scheduler.scheduler.dao.entities.Task;
import com.scheduler.scheduler.service.TaskScheduleService;
import com.scheduler.scheduler.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/task")
@CrossOrigin
public class TaskController {

    private TaskService taskService;
    private TaskScheduleService taskScheduleService;

    @Autowired
    public TaskController(TaskService taskService, TaskScheduleService taskScheduleService) {
        this.taskService = taskService;
        this.taskScheduleService = taskScheduleService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Task> findAllTasks() {
        return taskService.findAll();
    }

    @PostMapping("/id/{id}")
    @ResponseBody
    public Task addTaskToSchedule(@RequestBody TaskDTO taskDTO, @PathVariable Long id) {
        return taskService.addTaskToSchedule(taskDTO, id);
    }

    @PutMapping("/id/{id}")
    @ResponseBody
    public ResponseEntity setTaskCompleted(@PathVariable Long id) {
        taskService.setTaskCompleted(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/id/{id}")
    @ResponseBody
    public ResponseEntity deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }
}
