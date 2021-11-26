package com.example.alumni.controller;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.AlumniEducation;
import com.example.alumni.dao.EInfoDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import javax.ws.rs.core.Response;


import java.util.ArrayList;
import java.util.List;



@RunWith(MockitoJUnitRunner.class)
public class EInfoControllerTest {

    @Mock
    private final EInfoDAO alumniEducationMock = Mockito.mock(EInfoDAO.class);

    @InjectMocks
    private EInfoController eInfoController;

    @Test
    public void testPrimePath1() throws Exception {

        AlumniDetails alumniDetails = new AlumniDetails();
        alumniDetails.setId(1);
        eInfoController.setAlumniRegistration(alumniEducationMock);
        Mockito.when(alumniEducationMock.hasregistered(Mockito.eq(alumniDetails.getId()))).thenReturn(0);
        AlumniEducation alumniEducation = new AlumniEducation();
        alumniEducation.setCollege_name("");
        List<AlumniEducation> list = new ArrayList<>();
        list.add(alumniEducation);
        Response response = eInfoController.registerEducationDetails(list);
        //code 204 invalid details
        Assert.assertTrue(response.getStatus()==204);
    }

    @Test
    public void testPrimePath2() throws Exception {

        AlumniDetails alumniDetails = new AlumniDetails();
        alumniDetails.setId(1);
        eInfoController.setAlumniRegistration(alumniEducationMock);
        Mockito.when(alumniEducationMock.hasregistered(Mockito.eq(alumniDetails.getId()))).thenReturn(0);
        AlumniEducation alumniEducation = new AlumniEducation();
        alumniEducation.setCollege_name("IIM Bangalore");
        alumniEducation.setAddress("Bangalore");
        alumniEducation.setDegree("MBA");
        alumniEducation.setJoining_year(2020);
        alumniEducation.setPassing_year(2022);

        alumniEducation.setAlumni(alumniDetails);

        List<AlumniEducation> list = new ArrayList<>();
        list.add(alumniEducation);
        Response response = eInfoController.registerEducationDetails(list);
        //code 409 already exist
        Assert.assertTrue(response.getStatus()==409);
    }

    @Test
    public void testPrimePath3() throws Exception {

        AlumniDetails alumniDetails = new AlumniDetails();
        alumniDetails.setId(6);
        eInfoController.setAlumniRegistration(alumniEducationMock);
        Mockito.when(alumniEducationMock.hasregistered(Mockito.eq(alumniDetails.getId()))).thenReturn(1);
        AlumniEducation alumniEducation = new AlumniEducation();
        alumniEducation.setCollege_name("IIM Bangalore");
        alumniEducation.setAddress("Bangalore");
        alumniEducation.setDegree("MBA");
        alumniEducation.setJoining_year(2020);
        alumniEducation.setPassing_year(2022);

        alumniEducation.setAlumni(alumniDetails);

        List<AlumniEducation> list = new ArrayList<>();
        list.add(alumniEducation);

        Response response = eInfoController.registerEducationDetails(list);
        //code 200 ok
        Assert.assertTrue(response.getStatus()==200);
    }
}