package com.example.hrmsproject.business.concretes;

import com.example.hrmsproject.business.abstracts.CandidateService;
import com.example.hrmsproject.business.abstracts.CandidateVerificationCodeService;
import com.example.hrmsproject.business.concretes.mernis.DWRKPSPublicSoap;
import com.example.hrmsproject.core.results.ErrorResult;
import com.example.hrmsproject.core.results.Result;
import com.example.hrmsproject.core.results.SuccessResult;
import com.example.hrmsproject.dataAccess.abstracts.CandidateDao;
import com.example.hrmsproject.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private CandidateVerificationCodeService candidateVerificatonCodeService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, CandidateVerificationCodeService candidateVerificatonCodeService) {
        this.candidateDao = candidateDao;
        this.candidateVerificatonCodeService = candidateVerificatonCodeService;
    }

    @Override
    public List<Candidate> getCandidateList() {
        ArrayList<Candidate> candidateList = new ArrayList<>();
        for (Candidate candidate:
                this.candidateDao.findAll()) {
            if (this.candidateVerificatonCodeService.getVerificationCode(candidate.getId()).isVerified()) {
                candidateList.add(candidate);
            }
        }
        return candidateList;
    }

    @Override
    public Result saveCandidate(Candidate candidate) throws Exception {
        if (checkTheIdentityInUse(candidate).isSuccess()) {
            this.candidateDao.save(candidate);
        }
        return checkTheEmailInUse(candidate);
    }

    private Result checkTheIdentity(Candidate candidate) throws Exception {
        DWRKPSPublicSoap client = new DWRKPSPublicSoap();
        boolean checkTheCandidate = client.TCKimlikNoDogrula(Long.valueOf(candidate.getIdentificationCode()), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate());
        if (!checkTheCandidate) {
            return new ErrorResult(returnVerification(Verification.CheckTheIdentity));
        }
        return checkTheVerificationCode(candidate);
    }

    private Result checkTheEmailInUse(Candidate candidate) throws Exception {
        final List<Candidate> candidateList = getCandidateList();
        ArrayList emailList = new ArrayList();
        candidateList.stream().forEach(candidates -> emailList.add(candidates.getEmail()));
        for (Object email : emailList) {
            if (email.equals(candidate.getEmail())) {
                return new ErrorResult(returnVerification(Verification.EmailInUse));
            }
        }
        return checkTheIdentityInUse(candidate);
    }

    private Result checkTheIdentityInUse(Candidate candidate) throws Exception {
        final List<Candidate> candidateList = getCandidateList();
        ArrayList identityList = new ArrayList();
        candidateList.stream().forEach(candidates -> identityList.add(candidates.getEmail()));
        for (Object email : identityList) {
            if (email.equals(candidate.getIdentificationCode())) {
                return new ErrorResult(returnVerification(Verification.IdentityInUse));
            }
        }
        return checkTheIdentity(candidate);
    }

    private Result checkTheVerificationCode(Candidate candidate) {
        if(!this.candidateVerificatonCodeService.getVerificationCode(candidate.getId()).isVerified()){
            return new ErrorResult(returnVerification(Verification.VerificationCode));
        }
        return new SuccessResult(returnVerification(Verification.Success));

    }

    private enum Verification {
        CheckTheIdentity,
        EmailInUse,
        EmailVerification,
        IdentityInUse,
        VerificationCode,
        Success
    }

    private String returnVerification(Verification error) {
        switch (error) {
            case CheckTheIdentity:
                return "Girilen bilgiler kimlik numarası ile uyuşmuyor";
            case EmailInUse:
                return "Bu email kullanımda";
            case EmailVerification:
                return "Email henüz doğrulanmadı";
            case IdentityInUse:
                return "Bu kimlik numarası kullanımda";
            case Success:
                return "Kullanıcı başarılı bir şekilde kaydedildi";
            case VerificationCode:
                return "Email doğrulama hatası";
        }
        return "Bir şeyler ters gitti";
    }
}
