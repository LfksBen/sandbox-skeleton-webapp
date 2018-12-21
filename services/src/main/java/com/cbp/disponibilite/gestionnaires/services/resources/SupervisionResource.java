package com.cbp.disponibilite.gestionnaires.services.resources;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/private/open")
public class SupervisionResource {

    @GET
    @Path("/dispo")
    public Response dispo() {
        return Response.ok().build();
    }

}
