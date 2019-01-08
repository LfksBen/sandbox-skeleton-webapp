package com.cbp.disponibilite.gestionnaires.services.resources;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Component
@Path("/")
public class HelloWorldResource {

    @Value("${JDBC_CONNECTION_STRING}")
    private String conn;

    @Value("${JDBC_USER}")
    private String user;

    @Value("${JDBC_PASSWORD}")
    private String pass;

    @GET
    public Response findAll() {
        return Response.status(200).entity("Hello" + conn + " " + user + " " + pass).build();
    }

}
