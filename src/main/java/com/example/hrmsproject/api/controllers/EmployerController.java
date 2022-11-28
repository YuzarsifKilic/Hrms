package com.example.hrmsproject.api.controllers;

import com.example.hrmsproject.business.abstracts.EmployerService;
import com.example.hrmsproject.entities.concretes.Candidate;
import com.example.hrmsproject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public List<Employer> getAllEmployer() {
        return this.employerService.getEmployerList();
    }

    @PostMapping("/saveEmployer")
    public ResponseEntity<String> saveEmployer(@RequestBody Employer employer) {

        if (this.employerService.saveEmployer(employer).isSuccess()) {
            return ResponseEntity.ok(this.employerService.saveEmployer(employer).getMessage());
        }
        return ResponseEntity.badRequest().body(this.employerService.saveEmployer(employer).getMessage());
    }
}
