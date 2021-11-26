package com.example.alumni.dao;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.Student;
import com.example.alumni.utils.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FetchAlumniDetails {

    public List<Student> getAlumni(Student student){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        Query fetchquery =session.createQuery("from Student where fname like '%"+student.getFname()+"%'" +
                " or lname like '%"+student.getLname()+"%'" +
                " and year="+student.getYear());
        List<Student> alumnilist= fetchquery.list();
        transaction.commit();
        session.close();
        return alumnilist;
    }

    public boolean ispresent(AlumniDetails alumni){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        Query fetchquery =session.createQuery("from AlumniDetails where student_id="+alumni.getStudent().getId());
        AlumniDetails temp = (AlumniDetails) fetchquery.uniqueResult();
        transaction.commit();
        session.close();
        return  temp!=null;
    }
}
