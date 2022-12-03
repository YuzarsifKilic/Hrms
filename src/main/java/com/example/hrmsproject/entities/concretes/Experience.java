package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "experiences")
public class Experience {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "entry_of_year")
    private int entryOfYear;

    @Column(name = "quit_of_year")
    private int quitOfYear;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitle experienceJobTitle;

    @ManyToMany(mappedBy = "experiences")
    private List<Cv> cvs;

    public Experience() {}

    public Experience(int id, String companyName, int entryOfYear, int quitOfYear, JobTitle experienceJobTitle, List<Cv> cvs) {
        this.id = id;
        this.companyName = companyName;
        this.entryOfYear = entryOfYear;
        this.quitOfYear = quitOfYear;
        this.experienceJobTitle = experienceJobTitle;
        this.cvs = cvs;
    }

    public JobTitle getExperienceJobTitle() {
        return experienceJobTitle;
    }

    public void setExperienceJobTitle(JobTitle jobTitle) {
        this.experienceJobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEntryOfYear() {
        return entryOfYear;
    }

    public void setEntryOfYear(int entryOfYear) {
        this.entryOfYear = entryOfYear;
    }

    public int getQuitOfYear() {
        return quitOfYear;
    }

    public void setQuitOfYear(int quitOfYear) {
        this.quitOfYear = quitOfYear;
    }

    public List<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(List<Cv> cvs) {
        this.cvs = cvs;
    }
}
