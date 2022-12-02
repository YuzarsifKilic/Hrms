package com.example.hrmsproject.entities.concretes.dto;

public class JobAdvertisementWithEmployerDto {

    private int id;
    private String jobDefinition;
    private int salaryMin;
    private int salaryMax;
    private int positionCount;
    private int advertisementDeadline;
    private boolean isActive;
    private String companyName;

    private String cityName;

    private String jobTitle;

    public JobAdvertisementWithEmployerDto(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public JobAdvertisementWithEmployerDto(int id, String jobDefinition, int salaryMin, int salaryMax, int positionCount, int advertisementDeadline, boolean isActive, String companyName, String cityName, String jobTitle) {
        this.id = id;
        this.jobDefinition = jobDefinition;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.positionCount = positionCount;
        this.advertisementDeadline = advertisementDeadline;
        this.isActive = isActive;
        this.companyName = companyName;
        this.cityName = cityName;
        this.jobTitle = jobTitle;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
