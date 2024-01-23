package com.timer.task.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateTaskDTO(
    @Size(min = 3, message = "{validation.name.size.too_short}")
    String task,
    @Min(60)
    Integer secondsAmount
) {

}
