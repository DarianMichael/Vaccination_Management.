package com.example.vaccinationmanagementsystem.repository;

import com.example.vaccinationmanagementsystem.models.AgePriority;
import com.example.vaccinationmanagementsystem.models.DiseasePriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseasePriorityRepository extends JpaRepository<DiseasePriority, Long> {
}
