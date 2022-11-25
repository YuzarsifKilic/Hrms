package com.example.hrmsproject.dataAccess.abstracts;

import com.example.hrmsproject.entities.concretes.ConfirmsEmployer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmsEmployerDao extends JpaRepository<ConfirmsEmployer, Integer> {
    ConfirmsEmployer findByEmployerId(int employerId);
}
