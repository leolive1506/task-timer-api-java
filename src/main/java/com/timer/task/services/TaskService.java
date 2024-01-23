package com.timer.task.services;

import java.time.LocalDateTime;
import java.util.Map;

import com.timer.task.dtos.UpdateTaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.timer.task.domain.Task;
import com.timer.task.dtos.CreateTaskDTO;
import com.timer.task.repositories.TaskRepository;

@Service
public class TaskService {
  @Autowired
  private TaskRepository repository;

  public Page<Task> list(Map<String, String> filter) {
    String limitFilter = filter.get("_limit");
    String taskFilter = filter.get("task_like");
    String pageFilter = filter.get("_page");

    Integer limit = (limitFilter != null) ? Integer.parseInt(limitFilter) : 5;
    Integer page = (pageFilter != null) ? Integer.parseInt(pageFilter) : 0;

    if (taskFilter != null) {
      return this.repository.findByTaskContaining(
        taskFilter,
        PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "id"))
      );
    }
    return this.repository.findAll(
      PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "id"))
    );
  }

  public Task save(Task task) {
    return this.repository.save(task);
  }

  public Task createTask(CreateTaskDTO taskDTO) {
    Task task = new Task(taskDTO);
    return this.save(task);
  }

  public Task update(UpdateTaskDTO taskDTO, Long id) {
    Task task = this.repository.findById(id).orElseThrow();

    if (taskDTO.task() != null) {
      task.setTask(taskDTO.task());
    }

    if (taskDTO.secondsAmount() != null) {
      task.setSecondsAmount(taskDTO.secondsAmount());
    }
    
    return this.save(task);
  }

  public Task completeTask(Long id) {
    Task task = this.repository.findById(id).orElseThrow();
    task.setFinishedAt(LocalDateTime.now());
  
    return this.save(task);
  }

  public Task interruptTask(Long id) {
    Task task = this.repository.findById(id).orElseThrow();
    task.setInterruptedAt(LocalDateTime.now());

    return this.save(task);
  }
}
