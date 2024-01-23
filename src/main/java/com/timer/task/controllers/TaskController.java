package com.timer.task.controllers;

import java.util.Map;

import com.timer.task.dtos.UpdateTaskDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timer.task.domain.Task;
import com.timer.task.dtos.CreateTaskDTO;
import com.timer.task.services.TaskService;

@RestController
@RequestMapping("tasks")
@CrossOrigin(origins = "*")
public class TaskController {
  @Autowired
  private TaskService service;

  @GetMapping
  public ResponseEntity<Page<Task>> list(@RequestParam(required = false) Map<String, String> request) {
    Page<Task> tasks = this.service.list(request);
    return new ResponseEntity<>(tasks, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Task> create(@RequestBody @Valid CreateTaskDTO taskDTO) {
    Task task = service.createTask(taskDTO);
    return new ResponseEntity<>(task, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Task> update(@RequestBody @Valid UpdateTaskDTO taskDTO, @PathVariable Long id) {
    Task task = service.update(taskDTO, id);
    return ResponseEntity.ok().body(task);
  }

  @PutMapping("/{id}/complete")
  public ResponseEntity<Task> complete(@PathVariable Long id) {
    Task task = service.completeTask(id);
    return ResponseEntity.ok().body(task);
  }

  @PutMapping("/{id}/interrupt")
  public ResponseEntity<Task> interrupt(@PathVariable Long id) {
    Task task = service.interruptTask(id);
    return ResponseEntity.ok().body(task);
  }
}
