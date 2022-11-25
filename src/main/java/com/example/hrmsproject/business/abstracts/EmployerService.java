package com.example.hrmsproject.business.abstracts;

import com.example.hrmsproject.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    List<Employer> getEmployerList();
    boolean saveEmployer(Employer employer);

    String getEmployerMessage(Employer employer);
}
