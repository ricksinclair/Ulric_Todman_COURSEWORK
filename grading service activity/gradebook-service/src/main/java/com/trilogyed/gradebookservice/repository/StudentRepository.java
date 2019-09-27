package com.trilogyed.gradebookservice.repository;

import com.trilogyed.gradebookservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
