package com.trilogyed.gradebookservice.repository;

import com.trilogyed.gradebookservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

    @Transactional
    public Grade findById(int id);
}

