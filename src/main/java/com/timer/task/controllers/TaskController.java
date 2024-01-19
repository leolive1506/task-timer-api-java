package com.timer.task.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping
  public ResponseEntity<List<Task>> list() {
    List<Task> tasks = this.service.list();
    return new ResponseEntity<>(tasks, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO) {
    Task task = service.createTask(taskDTO);
    return new ResponseEntity<>(task, HttpStatus.CREATED);
  }
}
