package com.trilogyed.gradebookservice.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.trilogyed.gradebookservice.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

    @Transactional
    public Assignment findById(int id);
}
