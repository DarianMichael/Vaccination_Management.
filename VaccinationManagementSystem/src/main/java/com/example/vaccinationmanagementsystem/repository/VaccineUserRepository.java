package com.example.vaccinationmanagementsystem.repository;

import com.example.vaccinationmanagementsystem.models.AgeRange;
import com.example.vaccinationmanagementsystem.models.VaccineUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineUserRepository extends JpaRepository<VaccineUser, Long> {

}
