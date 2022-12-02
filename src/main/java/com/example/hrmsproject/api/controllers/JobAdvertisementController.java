package com.example.hrmsproject.api.controllers;

import com.example.hrmsproject.business.abstracts.JobAdvertisementService;
import com.example.hrmsproject.core.results.DataResult;
import com.example.hrmsproject.core.results.Result;
import com.example.hrmsproject.entities.concretes.JobAdvertisement;
import com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWithEmployerDto;
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
    public DataResult<List<JobAdvertisementWithEmployerDto>> getWithDetail() {
        return this.jobAdvertisementService.getWithEmployerDetails();
    }

    @GetMapping("/getActiveJobAdvertisement")
    public DataResult<List<JobAdvertisementWithEmployerDto>> getWithActiveJobAdvertisement() {
        return this.jobAdvertisementService.getJobAdvertisementByIsActive();
    }

    @GetMapping("/getActiveJobAdvertisementOrderByDeadline")
    public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementByActiveOrderByDeadline() {
        return this.jobAdvertisementService.getJobAdvertisementByIsActiveOrderByDeadline();
    }

    @GetMapping("/getActiveJobAdvertisementByEmployerId")
    public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementByActiveByEmployerId(@RequestBody int employerId) {
        return this.jobAdvertisementService.getJobAdvertisementByEmployerId(employerId);
    }

    @GetMapping("/deleteJobAdvertisementById")
    public Result deleteJobAdvertisementById() {
        return this.jobAdvertisementService.deleteJobAdvertisementById(1);
    }
}