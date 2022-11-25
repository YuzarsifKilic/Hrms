package com.example.hrmsproject.business.concretes;

import com.example.hrmsproject.business.abstracts.EmployerVerificationCodeService;
import com.example.hrmsproject.dataAccess.abstracts.EmployerVerificationcodeDao;
import com.example.hrmsproject.entities.concretes.EmployerVerificatonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerVerificationCodeManager implements EmployerVerificationCodeService {

    private EmployerVerificationcodeDao employerVerificationcodeDao;

    @Autowired
    public EmployerVerificationCodeManager(EmployerVerificationcodeDao employerVerificationcodeDao) {
        this.employerVerificationcodeDao = employerVerificationcodeDao;
    }


    @Override
    public EmployerVerificatonCode getVerificationCode(int employerId) {
        return this.employerVerificationcodeDao.findByEmployerId(employerId);
    }
}
