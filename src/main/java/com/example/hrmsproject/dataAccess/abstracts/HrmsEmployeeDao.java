package com.example.hrmsproject.dataAccess.abstracts;

import com.example.hrmsproject.entities.concretes.HrmsEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrmsEmployeeDao extends JpaRepository<HrmsEmployee, Integer> {
}
