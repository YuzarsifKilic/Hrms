package com.example.hrmsproject.business.abstracts;

import com.example.hrmsproject.entities.concretes.Candidate;
import com.example.hrmsproject.entities.concretes.CandidateVerificatonCode;

import java.util.List;

public interface CandidateVerificationCodeService {
    CandidateVerificatonCode getVerificationCode(int candidateId);
}
