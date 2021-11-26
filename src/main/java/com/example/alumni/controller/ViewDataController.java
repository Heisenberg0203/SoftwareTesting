package com.example.alumni.controller;

import com.example.alumni.bean.AlumniDetails;
import com.example.alumni.bean.AlumniEducation;
import com.example.alumni.bean.AlumniOrganisation;
import com.example.alumni.dao.ViewDetailsDAO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("viewdata")
public class ViewDataController {


    @POST
    @Path("/pdetails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewpdetails(AlumniDetails adetials){
            AlumniDetails alumni = ViewDetailsDAO.getpdetails(adetials.getId());
            return Response.ok(alumni).build();
    }

    @POST
    @Path("/edetails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewedetaails(AlumniDetails adetails){
        List<AlumniEducation> edetails = ViewDetailsDAO.getedetails(adetails.getId());
        return  Response.ok(edetails).build();
    }

    @POST
    @Path("/odetails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewodetaails(AlumniDetails adetails){
        List<AlumniOrganisation> odetails = ViewDetailsDAO.getodetails(adetails.getId());
        return  Response.ok(odetails).build();
    }
}
