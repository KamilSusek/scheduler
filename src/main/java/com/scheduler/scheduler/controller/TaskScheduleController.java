package com.scheduler.scheduler.controller;

import com.scheduler.scheduler.dao.dtos.TaskScheduleDTO;
import com.scheduler.scheduler.dao.entities.TaskSchedule;
import com.scheduler.scheduler.service.TaskScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/schedule")
@CrossOrigin
public class TaskScheduleController {

    private TaskScheduleService taskScheduleService;

    @Autowired
    public TaskScheduleController(TaskScheduleService taskScheduleService) {
        this.taskScheduleService = taskScheduleService;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<TaskSchedule> findAllSchedules() {
        return taskScheduleService.findAllSchedules();
    }

    @GetMapping("/title/{title}")
    @ResponseBody
    public TaskSchedule findScheduleByTitle(@PathVariable String title) {
        return taskScheduleService.findScheduleByTitle(title);
    }

    @GetMapping("/id/{id}")
    @ResponseBody
    public TaskSchedule findScheduleById(@PathVariable Long id) {
        return taskScheduleService.findScheduleById(id);
    }

    @PostMapping("/add")
    @ResponseBody
    public TaskSchedule addSchedule(@RequestBody TaskScheduleDTO taskScheduleDTO) {
        return taskScheduleService.addSchedule(taskScheduleDTO);
    }

    @DeleteMapping("/id/{id}")
    @ResponseBody
    public ResponseEntity deleteSchedule(@PathVariable Long id) {
        taskScheduleService.delete(id);
        return ResponseEntity.ok().build();
    }

}
