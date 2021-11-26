package com.example.alumni.controller;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.dao.PInfoDAO;
import com.example.alumni.service.AlumniRegistration;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;


@Path("pinfo")
public class PInfoController {

        AlumniRegistration alumniRegistration = new AlumniRegistration();

        public void setAlumniRegistration(PInfoDAO pInfoDAO){
            alumniRegistration.setpInfoDAO(pInfoDAO);
        }

        @POST
        @Path("/register")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response registerAlumni(AlumniDetails alumni) throws URISyntaxException {
            System.out.println(alumni.getStudent().getId());
            System.out.println(alumni.getEmail());
            System.out.println(alumni.getContact());

            int returnvalue=alumniRegistration.insert_pinfo(alumni);
            if(returnvalue==1)
                return Response.ok().entity(alumni).build();
            else
                return Response.status(409).entity(alumni).build();


    }
}
