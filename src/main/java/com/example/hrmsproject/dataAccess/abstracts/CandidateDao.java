package com.example.hrmsproject.dataAccess.abstracts;

import com.example.hrmsproject.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
}
