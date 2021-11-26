package com.example.alumni.dao;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.Student;
import com.example.alumni.utils.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PInfoDAO {

    public int hasregistered(AlumniDetails alumni){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        alumni.setStudent(session.get(Student.class,alumni.getStudent().getId()));
        Query fetchquery =session.createQuery("from AlumniDetails where student_id ="+alumni.getStudent().getId());
        AlumniDetails temp = (AlumniDetails) fetchquery.uniqueResult();
        transaction.commit();
        session.close();
        if(temp==null) {
            return 1;
        }
        else{
            System.out.println(temp.toString());
            System.out.println("User already has registered");
            return 0;
        }
    }
    public void insertAlumniDetails(AlumniDetails alumni){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        alumni.setStudent(session.get(Student.class,alumni.getStudent().getId()));

        session.save(alumni);
        transaction.commit();
        session.close();
    }
}
