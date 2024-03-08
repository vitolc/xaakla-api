package com.vitulc.portfolio.app.dtos;

public record UpdateProjectDto(
        String projectName,
        String startDate,
        String endDate,
        String description) {
}
