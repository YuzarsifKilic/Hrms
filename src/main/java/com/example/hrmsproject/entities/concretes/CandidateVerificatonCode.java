package com.example.hrmsproject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "verification_code_candidates")

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class CandidateVerificatonCode extends VerificationCode{

    @Column(name = "candidate_id")
    private int candidateId;

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public CandidateVerificatonCode() {}

    public CandidateVerificatonCode(int id, String verificationCode, boolean isVerified, Date verifiedDate, int candidateId) {
        super(id, verificationCode, isVerified, verifiedDate);
        this.candidateId = candidateId;
    }
}
