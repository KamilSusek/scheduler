package com.scheduler.scheduler.error.exceptions;

public class ScheduleNotFoundException extends RuntimeException {
    public final static int ERROR_CODE = 404;
    private final static String ERROR_MESSAGE = "Could not find schedule.";

    public ScheduleNotFoundException() {
        super(ERROR_MESSAGE);
    }

    public ScheduleNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
