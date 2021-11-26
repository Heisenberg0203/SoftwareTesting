package com.example.alumni.controller;


import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.Student;
import com.example.alumni.dao.FetchAlumniDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {


    @Mock
    private FetchAlumniDetails alumniMock = Mockito.mock(FetchAlumniDetails.class);

    @InjectMocks
    private RegistrationController registrationController;

    @Test
    public void testPrimePath1() throws Exception {
        Student student = new Student();
        student.setFname("akash");
        registrationController.setFetchAlumniDetails(alumniMock);
        Mockito.when(alumniMock.getAlumni(Mockito.eq(student))).thenReturn(new ArrayList<>());
        Response response = registrationController.getStudents(student);
        List<Student> list = (List<Student>) response.getEntity();
        Assert.assertTrue(list.size() == 0);
    }

    @Test
    public void testPrimePath2() throws Exception {
        Student student = new Student();
        student.setFname("rushikesh");
        student.setId(1);
        registrationController.setFetchAlumniDetails(alumniMock);
        Mockito.when(alumniMock.getAlumni(Mockito.eq(student))).thenReturn(List.of(student));
        Response response = registrationController.getStudents(student);
        List<Student> list = (List<Student>) response.getEntity();
        Assert.assertTrue(list.size() > 0);
        AlumniDetails alumni = new AlumniDetails();
        alumni.setStudent(student);
        Mockito.when(alumniMock.ispresent(Mockito.eq(alumni))).thenReturn(true);
        Response regResponse = registrationController.isregistered(alumni);
        //not modified response code = 304
        Assert.assertTrue(regResponse.getStatus()==304);
    }

    @Test
    public void testPrimePath3() throws Exception{
        Student student = new Student();
        student.setFname("Rushikesh");
        student.setId(2);
        registrationController.setFetchAlumniDetails(alumniMock);
        Mockito.when(alumniMock.getAlumni(Mockito.eq(student))).thenReturn(List.of(student));
        Response response = registrationController.getStudents(student);
        List<Student> list = (List<Student>) response.getEntity();
        Assert.assertTrue(list.size() > 0);
        AlumniDetails alumni = new AlumniDetails();
        alumni.setStudent(student);
        Mockito.when(alumniMock.ispresent(Mockito.eq(alumni))).thenReturn(false);
        Response regResponse = registrationController.isregistered(alumni);
        //ok code = 200
        Assert.assertTrue(regResponse.getStatus()==200);
    }

}