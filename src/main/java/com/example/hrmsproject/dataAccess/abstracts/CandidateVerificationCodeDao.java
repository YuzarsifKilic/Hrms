package com.example.hrmsproject.dataAccess.abstracts;

import com.example.hrmsproject.entities.concretes.Candidate;
import com.example.hrmsproject.entities.concretes.CandidateVerificatonCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateVerificationCodeDao extends JpaRepository<CandidateVerificatonCode, Integer> {
    CandidateVerificatonCode findByCandidateId(int candidateId);
}
