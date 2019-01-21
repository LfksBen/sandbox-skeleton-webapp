package com.cbp.disponibilite.gestionnaires.services.resources;


import com.cbp.disponibilite.gestionnaires.manager.GestionnairesService;
import com.cbp.disponibilite.gestionnaires.model.constantes.FunctionnalErrorConstantes;
import com.cbp.disponibilite.gestionnaires.model.dto.GestionnaireDTO;
import com.cbp.disponibilite.gestionnaires.model.entities.Gestionnaire;
import com.cbp.disponibilite.gestionnaires.utils.ExceptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/gestionnaires")
@Api(value = "Ressources concernant les gestionnaires")
public class GestionnairesResource {


    @Autowired
    GestionnairesService service;

    @Autowired
    ExceptionService exceptionService;

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
    @Produces(MediaType.APPLICATION_JSON)
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
    public Response recupererGestionnaire(@QueryParam("matricule") final Long matricule) throws Exception {

        if (true) {
            throw exceptionService.genereException(FunctionnalErrorConstantes.TELEPHONIE_ERROR_50003, "LOL");
        }

        List<Gestionnaire> test = service.getGestionnaireByMatricule(matricule);

        return Response.status(200).entity("hello v" + appVersion + " sur l'host " + appHost + " " + conn + " " + user + " " + pass).build();
    }

}
