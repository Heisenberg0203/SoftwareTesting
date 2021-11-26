package com.example.alumni.bean;

import javax.persistence.*;

@Entity
public class AlumniEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private AlumniDetails alumni;
    @Column(nullable = false)
    private  String degree;
    @Column(nullable = false)
    private  int joining_year;
    @Column(nullable = false)
    private int passing_year;

    private String college_name;
    private String address;

    public AlumniEducation() {
    }

    public AlumniEducation(int id, AlumniDetails alumni, String degree, int joining_year, int passing_year, String college_name, String address) {
        this.id = id;
        this.alumni = alumni;
        this.degree = degree;
        this.joining_year = joining_year;
        this.passing_year = passing_year;
        this.college_name = college_name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlumniDetails getAlumni() {
        return alumni;
    }

    public void setAlumni(AlumniDetails alumni) {
        this.alumni = alumni;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getJoining_year() {
        return joining_year;
    }

    public void setJoining_year(int joining_year) {
        this.joining_year = joining_year;
    }

    public int getPassing_year() {
        return passing_year;
    }

    public void setPassing_year(int passing_year) {
        this.passing_year = passing_year;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AlumniEducation{" +
                "id=" + id +
                ", alumni=" + alumni +
                ", degree='" + degree + '\'' +
                ", joining_year=" + joining_year +
                ", passing_year=" + passing_year +
                ", college_name='" + college_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
