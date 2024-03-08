package com.vitulc.portfolio.app.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProjectDto(@NotBlank(message = "Project name is required") String projectName,
                         @NotNull(message = "Project start date is required") String startDate,
                         String endDate,
                         @NotBlank(message = "Project description is required") String description) {
}
