package com.trilogyed.gradebookservice.repository;

import com.trilogyed.gradebookservice.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
}
