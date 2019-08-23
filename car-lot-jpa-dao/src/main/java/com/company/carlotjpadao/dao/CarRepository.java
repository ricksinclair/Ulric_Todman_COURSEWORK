package com.company.carlotjpadao.dao;

import com.company.carlotjpadao.dto.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository  extends JpaRepository<Car, Integer> {

    List<Car> findByColor(String color);
    List<Car> findByMake(String color);
    List<Car> findByMakeAndColor(String make, String color);
}
