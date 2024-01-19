package com.timer.task.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timer.task.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  Page<Task> findByTaskContaining(String task, Pageable pageable);
  List<Task> findByTaskContaining(String task);
}
