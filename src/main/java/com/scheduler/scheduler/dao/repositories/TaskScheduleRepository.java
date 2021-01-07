package com.scheduler.scheduler.dao.repositories;

import com.scheduler.scheduler.dao.entities.TaskSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskScheduleRepository extends JpaRepository<TaskSchedule, Long> {
    Optional<TaskSchedule> findByTitle(String title);
}
