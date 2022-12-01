package com.example.hrmsproject.business.abstracts;

import com.example.hrmsproject.core.results.DataResult;
import com.example.hrmsproject.core.results.Result;
import com.example.hrmsproject.entities.concretes.JobAdvertisement;
import com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWtihEmployerDto;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    Result add(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisementWtihEmployerDto>> getWithEmployerDetails();

    DataResult<List<JobAdvertisementWtihEmployerDto>> getActiveJobAdvertisementDetails();

}
