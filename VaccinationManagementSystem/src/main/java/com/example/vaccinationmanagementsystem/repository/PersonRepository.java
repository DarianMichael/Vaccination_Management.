package com.example.vaccinationmanagementsystem.repository;

import com.example.vaccinationmanagementsystem.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
