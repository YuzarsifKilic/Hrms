package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "verification_codes")

@Inheritance(strategy = InheritanceType.JOINED)
public class VerificationCode {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "verification_code")
    private String verificationCode;
    @Column(name = "is_verified")
    private boolean isVerified;
    @Column(name = "verified_date")
    private Date verifiedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public Date getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public VerificationCode() {}

    public VerificationCode(int id, String verificationCode, boolean isVerified, Date verifiedDate) {
        this.id = id;
        this.verificationCode = verificationCode;
        this.isVerified = isVerified;
        this.verifiedDate = verifiedDate;
    }
}
