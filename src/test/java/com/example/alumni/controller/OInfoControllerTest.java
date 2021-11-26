package com.example.alumni.controller;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.AlumniOrganisation;
import com.example.alumni.bean.Organisation;
import com.example.alumni.dao.OInfoDAO;
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
public class OInfoControllerTest {


    @Mock
    private final OInfoDAO AlumniOrganisationMock = Mockito.mock(OInfoDAO.class);

    @InjectMocks
    private OInfoController oInfoController;

    @Test
    public void testPrimePath1(){
        AlumniOrganisation alumniOrganisation = new AlumniOrganisation();
        Organisation org = new Organisation();
        org.setName("Company");
        alumniOrganisation.setOrganisation(org);
        oInfoController.setAlumniRegistration(AlumniOrganisationMock);
        List<AlumniOrganisation> list = new ArrayList<>();
        list.add(alumniOrganisation);
        Response response = oInfoController.registerOrganisationDetails(list);
        //code 204 invalid details
        Assert.assertTrue(response.getStatus()==204);
    }

    @Test
    public void testPrimePath2(){
        AlumniOrganisation alumniOrganisation = new AlumniOrganisation();
        Organisation org = new Organisation();
        org.setName("Microsoft");
        org.setAddress("Bangalore");
        org.setId(1);
        alumniOrganisation.setOrganisation(org);
        alumniOrganisation.setJoining_year("2020");
        alumniOrganisation.setPosition("2022");
        alumniOrganisation.setId(10);
        alumniOrganisation.setPosition("SDE-1");
        AlumniDetails alumni = new AlumniDetails();
        alumni.setId(6);
        alumniOrganisation.setAlumni(alumni);
        oInfoController.setAlumniRegistration(AlumniOrganisationMock);
        List<AlumniOrganisation> list = new ArrayList<>();
        list.add(alumniOrganisation);

        Mockito.when(AlumniOrganisationMock.insertAlumniOrganisationDetails(Mockito.eq(list))).thenReturn(1);

        Response response = oInfoController.registerOrganisationDetails(list);
        //code 200 ok details inserted
        Assert.assertTrue(response.getStatus()==200);
    }
}