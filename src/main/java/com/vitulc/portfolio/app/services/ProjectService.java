package com.vitulc.portfolio.app.services;

import com.vitulc.portfolio.app.dtos.ProjectDto;
import com.vitulc.portfolio.app.dtos.ProjectResponseDto;
import com.vitulc.portfolio.app.dtos.UpdateProjectDto;
import com.vitulc.portfolio.app.entities.Project;
import com.vitulc.portfolio.app.errors.exceptions.BadRequestException;
import com.vitulc.portfolio.app.errors.exceptions.NotFoundException;
import com.vitulc.portfolio.app.repositories.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static com.vitulc.portfolio.app.services.DateTimeService.parseDate;

@Service
public class ProjectService {

    private final UploadImageService uploadImageService;
    private final ProjectRepository projectRepository;

    public ProjectService(
            UploadImageService uploadImageService,
            ProjectRepository projectRepository) {

        this.uploadImageService = uploadImageService;
        this.projectRepository = projectRepository;
    }

    public ResponseEntity<String> create(ProjectDto projectDto) {
        var startDate = parseDate(projectDto.startDate());
        var endDate = parseDate(projectDto.endDate());
        var project = new Project(projectDto, startDate, endDate);
        projectRepository.save(project);
        return ResponseEntity.ok("Project created successfully");
    }

    public ResponseEntity<String> setProjectImage(Long id, MultipartFile image) {

        String imageUrl = uploadImageService.uploadImage(image);

        if (image.isEmpty()) {
            throw new BadRequestException("Image file is required");
        }

        var project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project not found"));

        project.setProjectImageUrl(imageUrl);
        projectRepository.save(project);

        return ResponseEntity.ok("Image uploaded successfully");
    }

    public ResponseEntity<List<ProjectResponseDto>> getProjects(){
        List<ProjectResponseDto> projectsList = projectRepository.findAll()
                .stream().map(ProjectResponseDto::new).toList();

        if (projectsList.isEmpty()){
            throw new NotFoundException("No projects to list");
        }

        return ResponseEntity.ok(projectsList);
    }

    public ResponseEntity<String> update(Long id, UpdateProjectDto updateProjectDto){

        if (updateProjectDto.startDate() == null
                && updateProjectDto.endDate() == null
                && updateProjectDto.projectName() == null
                && updateProjectDto.description() == null) {
            return ResponseEntity.badRequest().body("Update request contains no fields to update");
        }

        var project = projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Project not found"));

        Optional.ofNullable(updateProjectDto.startDate())
                .map(DateTimeService::parseDate)
                .ifPresent(project::setStartDate);

        Optional.ofNullable(updateProjectDto.endDate())
                .map(DateTimeService::parseDate)
                .ifPresent(project::setEndDate);

        Optional.ofNullable(updateProjectDto.projectName())
                .ifPresent(project::setProjectName);

        Optional.ofNullable(updateProjectDto.description())
                .ifPresent(project::setDescription);

        project.update(updateProjectDto, project.getStartDate(), project.getEndDate());
        projectRepository.save(project);

        return ResponseEntity.ok("Project updated successfully");
    }
}
