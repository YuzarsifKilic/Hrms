package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "majors")
public class Major {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "major_name")
    private String majorName;

    @OneToMany(mappedBy = "major")
    private List<Cv> cvs;

    public Major() {}

    public Major(int id, String majorName, List<Cv> cvs) {
        this.id = id;
        this.majorName = majorName;
        this.cvs = cvs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public List<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(List<Cv> cvs) {
        this.cvs = cvs;
    }
}
