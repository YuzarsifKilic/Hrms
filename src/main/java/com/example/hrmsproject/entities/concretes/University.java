package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "universities")
public class University {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "university_name")
    private String universityName;

    @OneToMany(mappedBy = "university")
    private List<Cv> cvs;

    public University() {}

    public University(int id, String universityName, List<Cv> cvs) {
        this.id = id;
        this.universityName = universityName;
        this.cvs = cvs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public List<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(List<Cv> cvs) {
        this.cvs = cvs;
    }
}
