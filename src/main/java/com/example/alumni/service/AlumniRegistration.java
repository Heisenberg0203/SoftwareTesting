package com.example.alumni.service;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.AlumniEducation;
import com.example.alumni.bean.AlumniOrganisation;
import com.example.alumni.dao.EInfoDAO;
import com.example.alumni.dao.OInfoDAO;
import com.example.alumni.dao.PInfoDAO;

import java.util.List;




public class AlumniRegistration {

    EInfoDAO eInfoDAO = new EInfoDAO();
    PInfoDAO pInfoDAO = new PInfoDAO();
    OInfoDAO oInfoDAO = new OInfoDAO();
    public void seteInfoDAO(EInfoDAO eInfoDAO){
        this.eInfoDAO = eInfoDAO;
    }
    public void setpInfoDAO(PInfoDAO pInfoDAO){ this.pInfoDAO = pInfoDAO; }
    public void setoInfoDAO(OInfoDAO oInfoDAO){ this.oInfoDAO=oInfoDAO;}

    public int insert_pinfo(AlumniDetails alumni){
        System.out.println("Service Layer hit");
        int returnvalue= pInfoDAO.hasregistered(alumni);
        System.out.println(returnvalue);
        if(returnvalue==1){
            pInfoDAO.insertAlumniDetails(alumni);
            return 1;
        }
        else
            return -1;
    }

    public int insert_einfo(List<AlumniEducation> edetails){

        int returnvalue = eInfoDAO.hasregistered(edetails.get(0).getAlumni().getId());
        if(returnvalue==0){
            return -1;
        }
        eInfoDAO.insertAlumniEducationDetails(edetails);
        return  1;

    }

    public int insert_oinfo(List<AlumniOrganisation> odetails){

            oInfoDAO.insertAlumniOrganisationDetails(odetails);
            return  1;

    }
}
