package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_confirms")

@Inheritance(strategy = InheritanceType.JOINED)
public class EmployeeConfirm {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "hrms_employee_id")
    private int hrmsEmployeeId;
    @Column(name = "isconfirmed")
    private boolean isConfirmed;
    @Column(name = "confirm_date")
    private Date confirmDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHrmsEmployeeId() {
        return hrmsEmployeeId;
    }

    public void setHrmsEmployeeId(int hrmsEmployeeId) {
        this.hrmsEmployeeId = hrmsEmployeeId;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public EmployeeConfirm() {}

    public EmployeeConfirm(int id, int hrmsEmployeeId, boolean isConfirmed, Date confirmDate) {
        this.id = id;
        this.hrmsEmployeeId = hrmsEmployeeId;
        this.isConfirmed = isConfirmed;
        this.confirmDate = confirmDate;
    }
}
