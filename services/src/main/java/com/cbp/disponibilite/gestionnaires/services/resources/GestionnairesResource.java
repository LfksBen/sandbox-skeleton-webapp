package com.cbp.disponibilite.gestionnaires.services.resources;


import com.cbp.disponibilite.gestionnaires.manager.GestionnairesService;
import com.cbp.disponibilite.gestionnaires.model.dto.GestionnaireDTO;
import com.cbp.disponibilite.gestionnaires.model.entities.Gestionnaire;
import io.swagger.annotations.*;
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
@Api(value = "Ressources concernant les gestionnaires")
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
    @ApiOperation(value = "Récupérer un gestionnaire à partir de son matricule ou TOUS les gestionnaires si aucun matricule n'est renseigné")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Renvoie le gestionnaire trouvé", response = GestionnaireDTO.class),
            @ApiResponse(code = 200, message = "Renvoie tous les gestionnaires trouvés", response = GestionnaireDTO[].class),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message =
                    "Erreur inattendue : xxx <br/>" +
                            "Pas de gestionnaire trouvé pour le matricule xxx <br/>" +
                            "Plusieurs gestionnaires ont été trouvés pour le matricule xxx", response = String.class)
    })
    public Response recupererGestionnaire(@QueryParam("matricule") final Long matricule) {
        List<Gestionnaire> test = service.getGestionnaireByMatricule(matricule);

        return Response.status(200).entity("hello " + conn + " " + user + " " + pass).build();
    }

}
