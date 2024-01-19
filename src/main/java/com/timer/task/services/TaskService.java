package com.timer.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timer.task.domain.Task;
import com.timer.task.dtos.TaskDTO;
import com.timer.task.repositories.TaskRepository;

@Service
public class TaskService {
  @Autowired
  private TaskRepository repository;

  public Task save(Task task) {
    return this.repository.save(task);
  }

  public Task createTask(TaskDTO taskDTO) {
    Task task = new Task(taskDTO);
    return this.save(task);
  }
}
