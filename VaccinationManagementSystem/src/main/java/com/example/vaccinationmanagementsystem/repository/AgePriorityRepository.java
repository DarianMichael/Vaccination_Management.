package com.example.vaccinationmanagementsystem.repository;

import com.example.vaccinationmanagementsystem.models.AgePriority;
import com.example.vaccinationmanagementsystem.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgePriorityRepository extends JpaRepository<AgePriority, Long> {
}
