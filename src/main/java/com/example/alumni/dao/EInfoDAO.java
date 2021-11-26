package com.example.alumni.dao;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.AlumniEducation;

import com.example.alumni.utils.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EInfoDAO {

    public void insertAlumniEducationDetails(List<AlumniEducation> edetails){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        for(AlumniEducation edetail:edetails){
            edetail.setAlumni(session.get(AlumniDetails.class,edetail.getAlumni().getId()));
            session.save(edetail);
        }


        transaction.commit();
        session.close();
    }

    public int hasregistered(int alumni_id){
        Session session = Main.getSession();
        Transaction transaction = session.beginTransaction();
        Query fetchquery =session.createQuery("from AlumniDetails where id ="+alumni_id);
        AlumniDetails temp = (AlumniDetails) fetchquery.uniqueResult();
        transaction.commit();
        session.close();
        if(temp==null) {
            return 1;
        }
        else{
            //System.out.println(temp.toString());
            System.out.println("User already has registered");
                return 0;
        }
    }
}
