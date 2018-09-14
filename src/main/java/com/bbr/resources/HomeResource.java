package com.bbr.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/home")
public class HomeResource {

    @GET
    public Response findAll() {
        return Response.status(200).entity("hello toto").build();
    }

}
