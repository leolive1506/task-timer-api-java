package com.timer.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timer.task.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
  
}
