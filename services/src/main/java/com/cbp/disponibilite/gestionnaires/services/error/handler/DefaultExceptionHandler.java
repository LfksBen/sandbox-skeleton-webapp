package com.cbp.disponibilite.gestionnaires.services.error.handler;

import com.cbp.disponibilite.gestionnaires.services.error.dto.ErreurGenesys;
import com.cbp.disponibilite.gestionnaires.services.error.utils.ExceptionHandlerUtils;
import com.cbp.disponibilite.gestionnaires.utils.MessageProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Récupère les Exceptions throw et fait un retour avec notre DTO ErreurGenesys
 */
@Provider
public class DefaultExceptionHandler implements ExceptionMapper<Exception> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @Autowired
    MessageProviderService messageProviderService;

    @Override
    public Response toResponse(Exception e) {
        LOGGER.error("Exception error", e);

        ErreurGenesys erreurGenesys = new ErreurGenesys();
        erreurGenesys.setStatus(getHttpStatus(e));
        erreurGenesys.setCode(getHttpStatus(e));
        erreurGenesys.setMessage(messageProviderService.getMessage("commun.error.500", e.getMessage()));

        return ExceptionHandlerUtils.toResponse(erreurGenesys, getHttpStatus(e));
    }

    private int getHttpStatus(Throwable ex) {
        if (ex instanceof WebApplicationException) {
            return ((WebApplicationException)ex).getResponse().getStatus(); //NICE way to combine both of methods, say it in the blog
        } else {
            return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(); //defaults to internal server error 500
        }
    }
}
