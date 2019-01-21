package com.cbp.disponibilite.gestionnaires.services.error.utils;

import com.cbp.disponibilite.gestionnaires.services.error.dto.ErreurGenesys;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Utilitaire pour les handler d'exception
 */
public class ExceptionHandlerUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerUtils.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ExceptionHandlerUtils() {

    }

    public static Response toResponse(final ErreurGenesys erreurGenesys, final int statusCode) {

        Object entity;
        try {
            entity = objectMapper.writeValueAsString(erreurGenesys);
        } catch (JsonProcessingException ex){
            LOGGER.error("Error lors du parsing JSON avec Jackson.", ex);
            throw new RuntimeException("Error lors du parsing JSON avec Jackson", ex);
        }

        LOGGER.info("Reponse : {}", entity);

        return Response.status(statusCode)
                .entity(entity)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
