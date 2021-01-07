package com.scheduler.scheduler.dao.repositories;

import com.scheduler.scheduler.dao.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
