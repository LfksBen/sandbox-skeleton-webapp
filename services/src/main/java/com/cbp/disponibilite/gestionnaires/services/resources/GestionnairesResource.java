package com.cbp.disponibilite.gestionnaires.services.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/home")
public class GestionnairesResource {

    @GET
    public Response findAll() {
        return Response.status(200).entity("hello toto").build();
    }

}
