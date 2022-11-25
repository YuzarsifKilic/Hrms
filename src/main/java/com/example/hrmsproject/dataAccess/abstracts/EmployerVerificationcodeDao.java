package com.example.hrmsproject.dataAccess.abstracts;

import com.example.hrmsproject.entities.concretes.CandidateVerificatonCode;
import com.example.hrmsproject.entities.concretes.EmployerVerificatonCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerVerificationcodeDao extends JpaRepository<EmployerVerificatonCode, Integer> {

    EmployerVerificatonCode findByEmployerId(int employerId);
}
