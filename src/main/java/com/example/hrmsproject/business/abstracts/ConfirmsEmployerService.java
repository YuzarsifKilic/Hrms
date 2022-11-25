package com.example.hrmsproject.business.abstracts;

import com.example.hrmsproject.entities.concretes.ConfirmsEmployer;

import java.util.List;

public interface ConfirmsEmployerService {
    ConfirmsEmployer getConfirmsForEmployer(int employerId);
}
