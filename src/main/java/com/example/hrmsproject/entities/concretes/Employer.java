package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "employerId")
    private List<JobAdvertisement> jobAdvertisements;

    public Employer() {}

    public Employer(int id, String email, String password, String companyName, String webSite, String phoneNumber, List<JobAdvertisement> jobAdvertisements) {
        super(id, email, password);
        this.companyName = companyName;
        this.webSite = webSite;
        this.phoneNumber = phoneNumber;
        this.jobAdvertisements = jobAdvertisements;
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

    public List<JobAdvertisement> getJobAdvertisements() {
        return jobAdvertisements;
    }

    public void setJobAdvertisements(List<JobAdvertisement> jobAdvertisements) {
        this.jobAdvertisements = jobAdvertisements;
    }
}
