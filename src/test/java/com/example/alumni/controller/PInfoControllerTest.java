package com.example.alumni.controller;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.Student;

import com.example.alumni.dao.PInfoDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;


@RunWith(MockitoJUnitRunner.class)
public class PInfoControllerTest {


    @Mock
    private final PInfoDAO alumniPersonalDetailsMock = Mockito.mock(PInfoDAO.class);

    @InjectMocks
    private PInfoController pInfoController;

    @Test
    public void testPrimePath1() throws Exception{
        Student student  = new Student();
        student.setId(1);
        AlumniDetails alumniDetails = new AlumniDetails();
        alumniDetails.setStudent(student);
        pInfoController.setAlumniRegistration(alumniPersonalDetailsMock);
        Mockito.when(alumniPersonalDetailsMock.hasregistered(Mockito.eq(alumniDetails))).thenReturn(0);
        Response response = pInfoController.registerAlumni(alumniDetails);
        //code 409 already present
        Assert.assertTrue(response.getStatus()==409);
    }

    @Test
    public void testPrimePath2() throws Exception{
        Student student  = new Student();
        student.setId(2);
        AlumniDetails alumniDetails = new AlumniDetails();
        alumniDetails.setStudent(student);
        pInfoController.setAlumniRegistration(alumniPersonalDetailsMock);
        Mockito.when(alumniPersonalDetailsMock.hasregistered(Mockito.eq(alumniDetails))).thenReturn(1);
        Response response = pInfoController.registerAlumni(alumniDetails);
        //code 200 ok can register details
        Assert.assertTrue(response.getStatus()==200);
    }
}