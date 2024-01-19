package com.timer.task.dtos;

import java.time.LocalDateTime;

public record TaskDTO(
  String task,
  Integer secondsAmount,
  LocalDateTime createdAt,
  LocalDateTime finishedAt,
  LocalDateTime interruptedAt
) {

}
