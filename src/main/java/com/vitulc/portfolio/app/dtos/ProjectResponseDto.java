package com.vitulc.portfolio.app.dtos;

import com.vitulc.portfolio.app.entities.Project;

import java.time.OffsetDateTime;

public record ProjectResponseDto(
        Long projectId,
        String projectName,
        OffsetDateTime startDate,
        OffsetDateTime endDate,
        String imageUrl) {

    public ProjectResponseDto(Project project) {
        this(
                project.getId(),
                project.getProjectName(),
                project.getStartDate(),
                project.getEndDate(),
                project.getProjectImageUrl());
    }
}
