package com.cbp.disponibilite.gestionnaires.services.resources;


import com.cbp.disponibilite.gestionnaires.services.manager.GestionnairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.lang.management.ManagementFactory;

@Component
@Path("/")
public class GestionnairesResource {

    @Autowired
    GestionnairesService service;

    @Value("${JDBC_CONNECTION_STRING}")
    private String conn;

    @Value("${JDBC_USER}")
    private String user;

    @Value("${JDBC_PASSWORD}")
    private String pass;

    @GET
    public Response findAll() {
        return Response.status(200).entity(service.getHello() + conn + " " + user + " " + pass + " " + ManagementFactory.getRuntimeMXBean().getInputArguments()).build();
    }

}
