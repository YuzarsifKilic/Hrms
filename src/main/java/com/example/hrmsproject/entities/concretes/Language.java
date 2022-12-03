package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "language_name")
    private String languageName;
    @OneToMany(mappedBy = "language")
    private List<Cv> cvs;

    public Language() {}

    public Language(int id, String languageName, List<Cv> cvs) {
        this.id = id;
        this.languageName = languageName;
        this.cvs = cvs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public List<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(List<Cv> cvs) {
        this.cvs = cvs;
    }
}
