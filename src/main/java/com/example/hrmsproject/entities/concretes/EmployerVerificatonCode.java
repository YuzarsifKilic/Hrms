package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "verificaiton_code_employers")

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class EmployerVerificatonCode extends VerificationCode{

    @Column(name = "employer_id")
    private int employerId;

    public EmployerVerificatonCode() {}

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public EmployerVerificatonCode(int id, String verificationCode, boolean isVerified, Date verifiedDate, int employerId) {
        super(id, verificationCode, isVerified, verifiedDate);
        this.employerId = employerId;
    }
}
