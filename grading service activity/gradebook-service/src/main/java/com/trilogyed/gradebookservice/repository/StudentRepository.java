package com.trilogyed.gradebookservice.repository;

import com.trilogyed.gradebookservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Transactional
    public Student findById(int id);
}
