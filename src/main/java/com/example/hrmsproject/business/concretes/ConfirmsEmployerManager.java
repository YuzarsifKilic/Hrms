package com.example.hrmsproject.business.concretes;

import com.example.hrmsproject.business.abstracts.ConfirmsEmployerService;
import com.example.hrmsproject.dataAccess.abstracts.ConfirmsEmployerDao;
import com.example.hrmsproject.entities.concretes.ConfirmsEmployer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfirmsEmployerManager implements ConfirmsEmployerService {

    private ConfirmsEmployerDao confirmsEmployerDao;

    @Autowired
    public ConfirmsEmployerManager(ConfirmsEmployerDao confirmsEmployerDao) {
        this.confirmsEmployerDao = confirmsEmployerDao;
    }


    @Override
    public ConfirmsEmployer getConfirmsForEmployer(int employerId) {
        return this.confirmsEmployerDao.findByEmployerId(employerId);
    }
}
