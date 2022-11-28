package com.example.hrmsproject.business.concretes;

import com.example.hrmsproject.business.abstracts.JobTitleService;
import com.example.hrmsproject.dataAccess.abstracts.JobTitleDao;
import com.example.hrmsproject.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public List<JobTitle> getAll() {
        return this.jobTitleDao.findAll();
    }
}
