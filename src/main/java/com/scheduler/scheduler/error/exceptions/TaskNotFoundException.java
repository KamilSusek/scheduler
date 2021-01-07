package com.scheduler.scheduler.error.exceptions;

public class TaskNotFoundException extends RuntimeException {
    public final static int ERROR_CODE = 404;
    private final static String ERROR_MESSAGE = "Could not find task.";

    public TaskNotFoundException() {
        super(ERROR_MESSAGE);
    }

    public TaskNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
