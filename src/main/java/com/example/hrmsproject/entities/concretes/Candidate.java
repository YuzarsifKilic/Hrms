package com.example.hrmsproject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class Candidate extends User {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "identification_code")
    private String identificationCode;
    @Column(name = "birth_date")
    private int birthDate;

    public Candidate() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public Candidate(int id, String email, String password, String firstName, String lastName, String identificationCode, int birthDate) {
        super(id, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationCode = identificationCode;
        this.birthDate = birthDate;
    }
}
