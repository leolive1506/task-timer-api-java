package com.timer.task.domain;

import java.time.LocalDateTime;

import com.timer.task.dtos.TaskDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tasks")
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String task;
  private Integer secondsAmount;
  private LocalDateTime createdAt;
  private LocalDateTime finishedAt;
  private LocalDateTime interruptedAt;

  public Task(TaskDTO taskDTO) {
    task = taskDTO.task();
    secondsAmount = taskDTO.secondsAmount();
    createdAt = taskDTO.createdAt();
    finishedAt = taskDTO.finishedAt();
    interruptedAt = taskDTO.interruptedAt();
  }
}
