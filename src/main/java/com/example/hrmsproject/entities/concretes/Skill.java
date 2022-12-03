package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "skill_name")
    private String skillName;

    @ManyToMany(mappedBy = "skills")
    private List<Cv> cvs;

    public Skill() {}

    public Skill(int id, String skillName, List<Cv> cvs) {
        this.id = id;
        this.skillName = skillName;
        this.cvs = cvs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public List<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(List<Cv> cvs) {
        this.cvs = cvs;
    }
}
