package com.example.hrmsproject.business.abstracts;

import com.example.hrmsproject.core.results.DataResult;
import com.example.hrmsproject.core.results.Result;
import com.example.hrmsproject.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    Result add(JobAdvertisement jobAdvertisement);
}
