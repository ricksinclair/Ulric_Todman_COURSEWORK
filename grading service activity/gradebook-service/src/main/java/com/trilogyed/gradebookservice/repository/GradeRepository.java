package com.trilogyed.gradebookservice.repository;

import com.trilogyed.gradebookservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
