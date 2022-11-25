package com.example.hrmsproject.business.concretes;

import com.example.hrmsproject.business.abstracts.ConfirmsEmployerService;
import com.example.hrmsproject.business.abstracts.EmployerService;
import com.example.hrmsproject.business.abstracts.EmployerVerificationCodeService;
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
    public boolean saveEmployer(Employer employer) {
       return websiteAndEmailCompatibility(employer).equals(Verification.Success);
    }

    @Override
    public String getEmployerMessage(Employer employer) {
        return websiteAndEmailCompatibility(employer);
    }

    private String checkTheVerifications(Employer employer) {
        return websiteAndEmailCompatibility(employer);
    }

    private String websiteAndEmailCompatibility(Employer employer) {
        String websiteDomain[] = employer.getWebSite().split("\\.");
        String email[] = employer.getEmail().split("@");
        String companyName[] = email[1].split("\\.");

        if (websiteDomain[1].equals(companyName[0])) {

            return checkTheVerificationCode(employer).equals(returnVerification(Verification.Success)) ? returnVerification(Verification.Success) : checkTheVerificationCode(employer);
        }
        return returnVerification(Verification.WebsiteAndEmailCompatibility);
    }

    private String checkTheVerificationCode(Employer employer) {
        if(!this.employerVerificationCodeService.getVerificationCode(employer.getId()).isVerified()) {
            return returnVerification(Verification.VerificationCode);
        }
        return checkTheConfirm(employer).equals(returnVerification(Verification.Success)) ? returnVerification(Verification.Success) : checkTheConfirm(employer);
    }

    private String checkTheConfirm(Employer employer) {
        if (!this.confirmsEmployerService.getConfirmsForEmployer(employer.getId()).isConfirmed()) {
            return returnVerification(Verification.Confirm);
        }
        return returnVerification(Verification.Success);
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
