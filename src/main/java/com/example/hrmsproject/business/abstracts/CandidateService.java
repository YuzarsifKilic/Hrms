package com.example.hrmsproject.business.abstracts;

import com.example.hrmsproject.core.Result;
import com.example.hrmsproject.entities.concretes.Candidate;
import com.example.hrmsproject.entities.concretes.User;

import java.util.List;

public interface CandidateService {
    List<Candidate> getCandidateList();
    Result saveCandidate(Candidate candidate) throws Exception;
}
