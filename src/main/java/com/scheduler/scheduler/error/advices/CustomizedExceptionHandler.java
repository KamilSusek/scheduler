package com.scheduler.scheduler.error.advices;

import com.scheduler.scheduler.error.exceptions.ScheduleNotFoundException;
import com.scheduler.scheduler.error.exceptions.TaskNotFoundException;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class CustomizedExceptionHandler {

    @ResponseBody
    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String taskNotFoundException(TaskNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ScheduleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String scheduleNotFoundException(ScheduleNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PropertyValueException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String scheduleNotFoundException(PropertyValueException ex) {
        return ex.getMessage();
    }
}
