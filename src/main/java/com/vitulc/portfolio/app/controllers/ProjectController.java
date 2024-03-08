package com.vitulc.portfolio.app.controllers;

import com.vitulc.portfolio.app.dtos.ProjectDto;
import com.vitulc.portfolio.app.dtos.ProjectResponseDto;
import com.vitulc.portfolio.app.dtos.UpdateProjectDto;
import com.vitulc.portfolio.app.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

        private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@Valid @RequestBody ProjectDto projectDto) {
        return projectService.create(projectDto);
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<String> setProjectImage(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image) {
        return projectService.setProjectImage(id, image);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProjectResponseDto>> getProjects() {
        return projectService.getProjects();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProject(@PathVariable("id") Long id, @RequestBody UpdateProjectDto updateProjectDto) {
        return projectService.update(id, updateProjectDto);
    }
}
