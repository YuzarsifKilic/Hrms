package com.example.hrmsproject.business.abstracts;

import com.example.hrmsproject.entities.concretes.Candidate;
import com.example.hrmsproject.entities.concretes.User;

import java.util.List;

public interface CandidateService {
    List<Candidate> getCandidateList();
    boolean saveCandidate(Candidate candidate) throws Exception;

    String getCandidateMessage(Candidate candidate) throws Exception;
}
