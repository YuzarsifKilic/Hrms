package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;

@Entity
@Table(name = "job_advertisement")
public class JobAdvertisement {

    @Id
    @GeneratedValue
    @Column(name = "job_advertisement_id")
    private int id;
    @Column(name = "job_definition")
    private String jobDefinition;
    @Column(name = "salary_min")
    private int salaryMin;
    @Column(name = "salary_max")
    private int salaryMax;
    @Column(name = "position_count")
    private int positionCount;
    @Column(name = "advertisement_deadline")
    private int advertisementDeadline;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "job_title_id", referencedColumnName = "job_title_id")
    private JobTitle jobTitle;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employerId;

    public JobAdvertisement() {}

    public JobAdvertisement(int id, String jobDefinition, int salaryMin, int salaryMax, int positionCount, int advertisementDeadline, City city, JobTitle jobTitle, Employer employerId) {
        this.id = id;
        this.jobDefinition = jobDefinition;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.positionCount = positionCount;
        this.advertisementDeadline = advertisementDeadline;
        this.city = city;
        this.jobTitle = jobTitle;
        this.employerId = employerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobDefinition() {
        return jobDefinition;
    }

    public void setJobDefinition(String jobDefinition) {
        this.jobDefinition = jobDefinition;
    }

    public int getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(int salaryMin) {
        this.salaryMin = salaryMin;
    }

    public int getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(int salaryMax) {
        this.salaryMax = salaryMax;
    }

    public int getPositionCount() {
        return positionCount;
    }

    public void setPositionCount(int positionCount) {
        this.positionCount = positionCount;
    }

    public int getAdvertisementDeadline() {
        return advertisementDeadline;
    }

    public void setAdvertisementDeadline(int advertisementDeadline) {
        this.advertisementDeadline = advertisementDeadline;
    }

    public City getCityId() {
        return city;
    }

    public void setCityId(City cityId) {
        this.city = cityId;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Employer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Employer employerId) {
        this.employerId = employerId;
    }
}
