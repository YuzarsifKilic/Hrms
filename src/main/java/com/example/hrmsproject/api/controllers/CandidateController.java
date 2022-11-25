package com.example.hrmsproject.api.controllers;

import com.example.hrmsproject.business.abstracts.CandidateService;
import com.example.hrmsproject.entities.concretes.Candidate;
import com.example.hrmsproject.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getAll")
    public List<Candidate> getAllCandidates() {
        return this.candidateService.getCandidateList();
    }

    @PostMapping("/saveCandidate")
    public ResponseEntity<String> saveCandidate(@RequestBody Candidate candidate) throws Exception {
        if (this.candidateService.saveCandidate(candidate)) {
            return ResponseEntity.ok(this.candidateService.getCandidateMessage(candidate));
        }
        return ResponseEntity.badRequest().body(this.candidateService.getCandidateMessage(candidate));
    }

}
