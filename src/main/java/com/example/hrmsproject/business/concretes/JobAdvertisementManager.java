package com.example.hrmsproject.business.concretes;

import com.example.hrmsproject.business.abstracts.JobAdvertisementService;
import com.example.hrmsproject.core.results.DataResult;
import com.example.hrmsproject.core.results.Result;
import com.example.hrmsproject.core.results.SuccessDataResult;
import com.example.hrmsproject.core.results.SuccessResult;
import com.example.hrmsproject.dataAccess.abstracts.JobAdvertisementDao;
import com.example.hrmsproject.entities.concretes.JobAdvertisement;
import com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWithEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Eklendi");
    }

    @Override
    public DataResult<List<JobAdvertisementWithEmployerDto>> getWithEmployerDetails() {
        return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(this.jobAdvertisementDao.getJobAdvertisementWithEmployerDetails());
    }

    @Override
    public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementByIsActive() {
        return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(this.jobAdvertisementDao.getJobAdvertisementByActive(true));
    }

    @Override
    public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementByIsActiveOrderByDeadline() {
        return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(this.jobAdvertisementDao.getJobAdvertisementByActiveOrderByDeadline(true));
    }

    @Override
    public DataResult<List<JobAdvertisementWithEmployerDto>> getJobAdvertisementByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisementWithEmployerDto>>(this.jobAdvertisementDao.getByEmployerId(true, employerId));
    }

    @Override
    public Result deleteJobAdvertisementById(int id) {
        this.jobAdvertisementDao.deleteById(id);
        return new SuccessResult("Başarıyla Silindi");
    }
}
