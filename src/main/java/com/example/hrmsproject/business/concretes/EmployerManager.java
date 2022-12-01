package com.example.hrmsproject.business.concretes;

import com.example.hrmsproject.business.abstracts.ConfirmsEmployerService;
import com.example.hrmsproject.business.abstracts.EmployerService;
import com.example.hrmsproject.business.abstracts.EmployerVerificationCodeService;
import com.example.hrmsproject.core.results.ErrorResult;
import com.example.hrmsproject.core.results.Result;
import com.example.hrmsproject.core.results.SuccessResult;
import com.example.hrmsproject.dataAccess.abstracts.EmployerDao;
import com.example.hrmsproject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    private EmployerVerificationCodeService employerVerificationCodeService;

    private ConfirmsEmployerService confirmsEmployerService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmployerVerificationCodeService employerVerificationCodeService, ConfirmsEmployerService confirmsEmployerService) {
        this.employerDao = employerDao;
        this.employerVerificationCodeService = employerVerificationCodeService;
        this.confirmsEmployerService = confirmsEmployerService;
    }

    @Override
    public List<Employer> getEmployerList() {
        ArrayList<Employer> employerList = new ArrayList<>();
        for (Employer employer:
             this.employerDao.findAll()) {
            if (this.employerVerificationCodeService.getVerificationCode(employer.getId()).isVerified()) {
                employerList.add(employer);
            }
        }
        return employerList;
    }

    @Override
    public Result saveEmployer(Employer employer) {
        if (websiteAndEmailCompatibility(employer).isSuccess()) {
            this.employerDao.save(employer);
        }
       return websiteAndEmailCompatibility(employer);
    }

    private Result websiteAndEmailCompatibility(Employer employer) {
        String websiteDomain[] = employer.getWebSite().split("\\.");
        String email[] = employer.getEmail().split("@");
        String companyName[] = email[1].split("\\.");

        if (!websiteDomain[1].equals(companyName[0])) {
            return new ErrorResult(returnVerification(Verification.WebsiteAndEmailCompatibility));
        }
        return checkTheVerificationCode(employer);
    }

    private Result checkTheVerificationCode(Employer employer) {
        if(!this.employerVerificationCodeService.getVerificationCode(employer.getId()).isVerified()) {
            return new ErrorResult(returnVerification(Verification.VerificationCode));
        }
        return checkTheConfirm(employer);
    }

    private Result checkTheConfirm(Employer employer) {
        if (!this.confirmsEmployerService.getConfirmsForEmployer(employer.getId()).isConfirmed()) {
            return new ErrorResult(returnVerification(Verification.Confirm));
        }
        return new SuccessResult(returnVerification(Verification.Success));
    }

    private enum Verification {
        Confirm,
        WebsiteAndEmailCompatibility,
        VerificationCode,
        Success
    }

    private String returnVerification(Verification error) {
        switch (error) {
            case Confirm:
                return "Çalışanlar tarafından onaylanmadı";
            case WebsiteAndEmailCompatibility:
                return "Website ve amil uyumsuzluğu";
            case Success:
                return "Kullanıcı başarılı bir şekilde kaydedildi";
            case VerificationCode:
                return "Email doğrulama hatası";
        }
        return "Bir şeyler ters gitti";
    }


}
