package com.example.hrmsproject.dataAccess.abstracts;

import com.example.hrmsproject.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
}
