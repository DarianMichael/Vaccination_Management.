package com.example.vaccinationmanagementsystem.repository;

import com.example.vaccinationmanagementsystem.models.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParamRepository extends JpaRepository<Param, Long> {
    Optional<String> findParamByName(String name);
}
