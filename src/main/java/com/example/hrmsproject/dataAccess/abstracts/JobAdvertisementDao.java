package com.example.hrmsproject.dataAccess.abstracts;

import com.example.hrmsproject.entities.concretes.JobAdvertisement;
import com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWtihEmployerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    @Query("Select new com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWtihEmployerDto" +
            "(ja.id, ja.jobDefinition, ja.salaryMin, ja.salaryMax, ja.positionCount, ja.advertisementDeadline, e.companyName, c.cityName, j.jobTitle)" +
            "From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.city c Inner Join ja.jobTitle j")
    List<JobAdvertisementWtihEmployerDto> getJobAdvertisementWithEmployerDetails();


}
