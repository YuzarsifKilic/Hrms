package com.example.hrmsproject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employers")

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class Employer extends User {

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "web_site")
    private String webSite;
    @Column(name = "phone_number")
    private String phoneNumber;

    public Employer() {}

    public Employer(int id, String email, String password, String companyName, String webSite, String phoneNumber) {
        super(id, email, password);
        this.companyName = companyName;
        this.webSite = webSite;
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
