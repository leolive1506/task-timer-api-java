package com.timer.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timer.task.domain.Task;
import com.timer.task.dtos.TaskDTO;
import com.timer.task.services.TaskService;

@RestController
@RequestMapping("tasks")
public class TaskController {
  @Autowired
  private TaskService service;

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO) {
    Task task = service.createTask(taskDTO);
    return new ResponseEntity<>(task, HttpStatus.CREATED);
  }
}
