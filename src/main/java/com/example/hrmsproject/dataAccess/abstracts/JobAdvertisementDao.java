package com.example.hrmsproject.dataAccess.abstracts;

import com.example.hrmsproject.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
}
