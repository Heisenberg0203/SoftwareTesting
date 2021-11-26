package com.example.alumni.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class AlumniOrganisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @ManyToOne
    private Organisation organisation;

    @ManyToOne
    private  AlumniDetails alumni;
    
    @Column(nullable = false)
    private  String position;
    @Column(nullable = false)
    private String joining_year;
    private String leaving_year;

    public AlumniOrganisation() {
    }

    public AlumniOrganisation(int id, Organisation organisation, AlumniDetails alumni, String position, String joining_year, String leaving_year) {
        this.id = id;
        this.organisation = organisation;
        this.alumni = alumni;
        this.position = position;
        this.joining_year = joining_year;
        this.leaving_year = leaving_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public AlumniDetails getAlumni() {
        return alumni;
    }

    public void setAlumni(AlumniDetails alumni) {
        this.alumni = alumni;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJoining_year() {
        return joining_year;
    }

    public void setJoining_year(String joining_year) {
        this.joining_year = joining_year;
    }

    public String getLeaving_year() {
        return leaving_year;
    }

    public void setLeaving_year(String leaving_year) {
        this.leaving_year = leaving_year;
    }

    @Override
    public String toString() {
        return "AlumniOrganisation{" +
                "id=" + id +
                ", organisation=" + organisation.toString() +
                ", alumni=" + alumni.toString() +
                ", position='" + position + '\'' +
                ", joining_year='" + joining_year + '\'' +
                ", leaving_year='" + leaving_year + '\'' +
                '}';
    }
}
