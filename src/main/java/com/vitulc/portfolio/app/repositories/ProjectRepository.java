package com.vitulc.portfolio.app.repositories;

import com.vitulc.portfolio.app.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {}
