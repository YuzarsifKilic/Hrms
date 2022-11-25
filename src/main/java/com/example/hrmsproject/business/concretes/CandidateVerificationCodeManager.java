package com.example.hrmsproject.business.concretes;

import com.example.hrmsproject.business.abstracts.CandidateVerificationCodeService;
import com.example.hrmsproject.dataAccess.abstracts.CandidateVerificationCodeDao;
import com.example.hrmsproject.entities.concretes.Candidate;
import com.example.hrmsproject.entities.concretes.CandidateVerificatonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateVerificationCodeManager implements CandidateVerificationCodeService {

    private CandidateVerificationCodeDao verificationCodeCandidateDao;

    @Autowired
    public CandidateVerificationCodeManager(CandidateVerificationCodeDao verificationCodeCandidateDao) {
        this.verificationCodeCandidateDao = verificationCodeCandidateDao;
    }

    @Override
    public CandidateVerificatonCode getVerificationCode(int candidateId) {
        return this.verificationCodeCandidateDao.findByCandidateId(candidateId);
    }
}
