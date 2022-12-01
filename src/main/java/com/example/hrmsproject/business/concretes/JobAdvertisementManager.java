package com.example.hrmsproject.business.concretes;

import com.example.hrmsproject.business.abstracts.JobAdvertisementService;
import com.example.hrmsproject.core.results.DataResult;
import com.example.hrmsproject.core.results.Result;
import com.example.hrmsproject.core.results.SuccessDataResult;
import com.example.hrmsproject.core.results.SuccessResult;
import com.example.hrmsproject.dataAccess.abstracts.JobAdvertisementDao;
import com.example.hrmsproject.entities.concretes.JobAdvertisement;
import com.example.hrmsproject.entities.concretes.dto.JobAdvertisementWtihEmployerDto;
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
    public DataResult<List<JobAdvertisementWtihEmployerDto>> getWithEmployerDetails() {
        return new SuccessDataResult<List<JobAdvertisementWtihEmployerDto>>(this.jobAdvertisementDao.getJobAdvertisementWithEmployerDetails());
    }

    @Override
    public DataResult<List<JobAdvertisementWtihEmployerDto>> getActiveJobAdvertisementDetails() {
        Calendar calendar = Calendar.getInstance();
        ArrayList<JobAdvertisementWtihEmployerDto> jobAdvertisementWtihEmployerDtos = new ArrayList<>();
        for (JobAdvertisementWtihEmployerDto jobAdvertisementWithEmployerDto:
                this.jobAdvertisementDao.getJobAdvertisementWithEmployerDetails()) {
            if (jobAdvertisementWithEmployerDto.getAdvertisementDeadline() >= calendar.get(Calendar.YEAR)) {
                jobAdvertisementWtihEmployerDtos.add(jobAdvertisementWithEmployerDto);
            }
        }
        return new SuccessDataResult<List<JobAdvertisementWtihEmployerDto>>(jobAdvertisementWtihEmployerDtos);
    }
}
