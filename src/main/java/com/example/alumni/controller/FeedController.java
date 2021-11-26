package com.example.alumni.controller;

import com.example.alumni.dao.FeedDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("feeds")
public class FeedController {
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchFeeds(){
        return Response.ok(FeedDAO.getFeeds()).build();
    }
}
