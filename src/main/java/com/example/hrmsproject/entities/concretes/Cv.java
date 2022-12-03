package com.example.hrmsproject.entities.concretes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cv")
public class Cv {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    @Column(name = "university_entry_year")
    private int universityEnterYear;
    @Column(name = "graduated_year")
    private int graduatedYear;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cv_experiences",
            joinColumns = { @JoinColumn(name = "cv_id") },
            inverseJoinColumns = { @JoinColumn(name = "experience_id") }
    )
    private List<Experience> experiences;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @Column(name = "language_level")
    private int languageLevel;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cv_skills",
            joinColumns = { @JoinColumn(name = "cv_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") }
    )
    private List<Skill> skills;
    @Column(name = "github_url")
    private String githubUrl;
    @Column(name = "linkedin_url")
    private String linkedInUrl;
    @Column(name = "title")
    private String title;

    public Cv() {}

    public Cv(int id, University university, Major major, int universityEnterYear, int graduatedYear, List<Experience> experiences, Language language, int languageLevel, String githubUrl, String linkedInUrl, String title) {
        this.id = id;
        this.university = university;
        this.major = major;
        this.universityEnterYear = universityEnterYear;
        this.graduatedYear = graduatedYear;
        this.experiences = experiences;
        this.language = language;
        this.languageLevel = languageLevel;
        this.githubUrl = githubUrl;
        this.linkedInUrl = linkedInUrl;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public int getUniversityEnterYear() {
        return universityEnterYear;
    }

    public void setUniversityEnterYear(int universityEnterYear) {
        this.universityEnterYear = universityEnterYear;
    }

    public int getGraduatedYear() {
        return graduatedYear;
    }

    public void setGraduatedYear(int graduatedYear) {
        this.graduatedYear = graduatedYear;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(int languageLevel) {
        this.languageLevel = languageLevel;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
