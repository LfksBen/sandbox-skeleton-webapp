package com.cbp.disponibilite.gestionnaires.services.resources;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/healthcheck")
public class SupervisionResource {

    private final static Logger LOG = LoggerFactory.getLogger(SupervisionResource.class);

    @GET
    @Path("/ping")
    public Response ping() {
        LOG.error("Test acces Supervision");
        return Response.ok().build();
    }

}
