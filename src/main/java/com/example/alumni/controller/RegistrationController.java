package com.example.alumni.controller;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.Student;
import com.example.alumni.utils.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;
import com.example.alumni.dao.FetchAlumniDetails;



@Path("alumni")
public class RegistrationController {

    FetchAlumniDetails fetchAlumniDetails = new FetchAlumniDetails();

    public void setFetchAlumniDetails(FetchAlumniDetails fetchAlumniDetails) {
        this.fetchAlumniDetails = fetchAlumniDetails;
    }

    @POST
    @Path("/getinfo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getStudents(Student student) throws URISyntaxException {
        System.out.println(student.getFname());
        System.out.println(student.getLname());
        System.out.println(student.getYear());

        List<Student> alumnistudent = fetchAlumniDetails.getAlumni(student);
//        for(Student alumni:alumnistudent){
//            System.out.println(alumni.getId());
//            System.out.println(alumni.getFname());
//            System.out.println(alumni.getRoll());
//            System.out.println(alumni.getEmail());
//
//
//        }
        
        return Response.ok().entity(alumnistudent).build();

    }

    @POST
    @Path(("/isregistered"))
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response isregistered(AlumniDetails alumni){
        boolean present = fetchAlumniDetails.ispresent(alumni);

        if(!present)
            return Response.ok().build();
        else
            return Response.notModified().build();
    }
}
