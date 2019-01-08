package com.cbp.disponibilite.gestionnaires.services.resources;


import com.cbp.disponibilite.gestionnaires.manager.GestionnairesService;
import com.cbp.disponibilite.gestionnaires.model.entities.Gestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/gestionnaires")
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
    @Transactional
    public Response recupererGestionnaire(@QueryParam("matricule") final Long matricule) {
        List<Gestionnaire> test = service.getGestionnaireByMatricule(matricule);

        return Response.status(200).entity("hello " + conn + " " + user + " " + pass).build();
    }

}
