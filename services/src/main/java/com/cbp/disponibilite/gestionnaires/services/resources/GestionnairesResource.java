package com.cbp.disponibilite.gestionnaires.services.resources;


import com.cbp.disponibilite.gestionnaires.manager.GestionnairesService;
import com.cbp.disponibilite.gestionnaires.model.entities.Gestionnaire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger LOG = LoggerFactory.getLogger(GestionnairesResource.class);

    @Autowired
    GestionnairesService service;

    @Value("${JDBC_CONNECTION_STRING}")
    private String conn;

    @Value("${JDBC_USER}")
    private String user;

    @Value("${JDBC_PASSWORD}")
    private String pass;

    @Value("${app.version}")
    private String appVersion;

    @Value("${APP_HOST}")
    private String appHost;

    @GET
    @Transactional
    public Response recupererGestionnaire(@QueryParam("matricule") final Long matricule) {
        List<Gestionnaire> test = service.getGestionnaireByMatricule(matricule);

        return Response.status(200).entity("hello v" + appVersion + " sur l'host " + appHost + " " + conn + " " + user + " " + pass).build();
    }

}
