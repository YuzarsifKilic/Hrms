package com.example.hrmsproject.api.controllers;

import com.example.hrmsproject.business.abstracts.JobAdvertisementService;
import com.example.hrmsproject.core.results.DataResult;
import com.example.hrmsproject.core.results.Result;
import com.example.hrmsproject.entities.concretes.Employer;
import com.example.hrmsproject.entities.concretes.JobAdvertisement;
import com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWtihEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @PostMapping("/add")
    public Result saveJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/getWithDetails")
    public DataResult<List<JobAdvertisementWtihEmployerDto>> getWithDetail() {
        return this.jobAdvertisementService.getWithEmployerDetails();
    }

    @GetMapping("/getWithActiveJobAdvertisement")
    public DataResult<List<JobAdvertisementWtihEmployerDto>> getWithActiveJobAdvertisement() {
        return this.jobAdvertisementService.getActiveJobAdvertisementDetails();
    }

}
