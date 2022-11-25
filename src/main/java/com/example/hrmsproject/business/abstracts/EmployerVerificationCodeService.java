package com.example.hrmsproject.business.abstracts;

import com.example.hrmsproject.entities.concretes.CandidateVerificatonCode;
import com.example.hrmsproject.entities.concretes.EmployerVerificatonCode;

import java.util.List;

public interface EmployerVerificationCodeService {
    EmployerVerificatonCode getVerificationCode(int employerId);
}
