package com.cbp.disponibilite.gestionnaires.services.error.handler;

import com.cbp.disponibilite.gestionnaires.model.exceptions.FunctionnalException;
import com.cbp.disponibilite.gestionnaires.services.error.dto.ErreurGenesys;
import com.cbp.disponibilite.gestionnaires.services.error.utils.ExceptionHandlerUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Récupère les Exceptions throw et fait un retour avec notre DTO ErreurGenesys
 */
@Provider
public class FunctionnalExceptionHandler implements ExceptionMapper<FunctionnalException> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionnalExceptionHandler.class);

    public ObjectMapper objectMapper;

    public FunctionnalExceptionHandler() {
        super();
        objectMapper = new ObjectMapper();
    }

    @Override
    public Response toResponse(FunctionnalException e) {
        LOGGER.error("Exception error", e);

        ErreurGenesys erreurGenesys = new ErreurGenesys(e);

        return ExceptionHandlerUtils.toResponse(erreurGenesys, e.getStatus());
    }
}
