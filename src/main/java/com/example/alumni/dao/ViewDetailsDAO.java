package com.example.alumni.dao;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.AlumniEducation;
import com.example.alumni.bean.AlumniOrganisation;
import com.example.alumni.utils.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ViewDetailsDAO {

    public static AlumniDetails getpdetails(int aid){
        Session session = Main.getSession();
        Query fetchquery =session.createQuery("from AlumniDetails where id="+aid);
        AlumniDetails alumni = (AlumniDetails)fetchquery.uniqueResult();
        session.close();
        return alumni;
    }

    public static List<AlumniEducation> getedetails(int aid){
        Session session = Main.getSession();
        Query fetchquery = session.createQuery("from AlumniEducation where alumni_id="+aid);
        List<AlumniEducation> edetails = fetchquery.list();

        session.close();
        return edetails;


    }

    public static List<AlumniOrganisation> getodetails(int aid){
        Session session = Main.getSession();
        Query fetchquery = session.createQuery("from AlumniOrganisation where alumni_id="+aid);
        List<AlumniOrganisation> odetails = fetchquery.list();

        session.close();
        return odetails;


    }
}

