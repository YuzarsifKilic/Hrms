package com.example.hrmsproject.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class JobTitle {

    @Id
    @GeneratedValue
    @Column(name = "job_title_id")
    private int id;

    @Column(name = "job_title")
    private String jobTitle;

    @OneToMany(mappedBy = "jobTitle", fetch = FetchType.LAZY)
    private List<JobAdvertisement> jobAdvertisements;

     @OneToMany(mappedBy = "experienceJobTitle", fetch = FetchType.LAZY)
    private List<Experience> experiences;

    public JobTitle() {}

    public JobTitle(int id, String jobTitle, List<JobAdvertisement> jobAdvertisements) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.jobAdvertisements = jobAdvertisements;
    }

    public JobTitle(String jobTitle, List<Experience> experiences) {
        this.jobTitle = jobTitle;
        this.experiences = experiences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<JobAdvertisement> getJobAdvertisements() {
        return jobAdvertisements;
    }

    public void setJobAdvertisements(List<JobAdvertisement> jobAdvertisements) {
        this.jobAdvertisements = jobAdvertisements;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
}
