package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_confirms_employers")

@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class ConfirmsEmployer extends EmployeeConfirm{

    @Column(name = "employer_id")
    private int employerId;

    public ConfirmsEmployer() {}

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public ConfirmsEmployer(int id, int hrmsEmployeeId, boolean isConfirmed, Date confirmDate, int employerId) {
        super(id, hrmsEmployeeId, isConfirmed, confirmDate);
        this.employerId = employerId;
    }
}
