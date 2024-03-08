package com.vitulc.portfolio.app.entities;

import com.vitulc.portfolio.app.dtos.ProjectDto;
import com.vitulc.portfolio.app.dtos.UpdateProjectDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    private OffsetDateTime startDate;

    private OffsetDateTime endDate;

    private String projectImageUrl;

    private String description;

    public Project(ProjectDto projectDto, OffsetDateTime startDate, OffsetDateTime endDate) {
        this.projectName = projectDto.projectName();
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = projectDto.description();
    }

    public Project() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public String getProjectImageUrl() {
        return projectImageUrl;
    }

    public void setProjectImageUrl(String projectImageUrl) {
        this.projectImageUrl = projectImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void update(UpdateProjectDto updateProjectDto, OffsetDateTime startDate, OffsetDateTime endDate) {

    }
}
