package com.example.hrmsproject.dataAccess.abstracts;

import com.example.hrmsproject.entities.concretes.JobAdvertisement;
import com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWithEmployerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    @Query("Select new com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWithEmployerDto" +
            "(ja.id, ja.jobDefinition, ja.salaryMin, ja.salaryMax, ja.positionCount, ja.advertisementDeadline, ja.isActive, e.companyName, c.cityName, j.jobTitle)" +
            "From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.city c Inner Join ja.jobTitle j")
    List<JobAdvertisementWithEmployerDto> getJobAdvertisementWithEmployerDetails();
    @Query("Select new com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWithEmployerDto" +
            "(ja.id, ja.jobDefinition, ja.salaryMin, ja.salaryMax, ja.positionCount, ja.advertisementDeadline, ja.isActive, e.companyName, c.cityName, j.jobTitle)" +
            "From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.city c Inner Join ja.jobTitle j where ja.isActive=:isActive")
    List<JobAdvertisementWithEmployerDto> getJobAdvertisementByActive(boolean isActive);

    @Query("Select new com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWithEmployerDto" +
            "(ja.id, ja.jobDefinition, ja.salaryMin, ja.salaryMax, ja.positionCount, ja.advertisementDeadline, ja.isActive, e.companyName, c.cityName, j.jobTitle)" +
            "From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.city c Inner Join ja.jobTitle j where ja.isActive=:isActive order by ja.advertisementDeadline DESC")
    List<JobAdvertisementWithEmployerDto> getJobAdvertisementByActiveOrderByDeadline(boolean isActive);

    @Query("Select new com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWithEmployerDto" +
            "(ja.id, ja.jobDefinition, ja.salaryMin, ja.salaryMax, ja.positionCount, ja.advertisementDeadline, ja.isActive, e.companyName, c.cityName, j.jobTitle)" +
            "From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.city c Inner Join ja.jobTitle j where ja.isActive=:isActive and ja.employer.id=:employerId")
    List<JobAdvertisementWithEmployerDto> getByEmployerId(boolean isActive, int employerId);

}
