package com.cbp.disponibilite.gestionnaires.utils;

import com.cbp.disponibilite.gestionnaires.model.exceptions.FunctionnalException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe utilitaire permettant de créer des exceptions
 */
@Service
public class ExceptionService {

    @Autowired
    MessageProviderService messageProviderService;

    private ExceptionService() {}

    /**
     * Genère une exception de type 500 avec les paramètres donnés.
     *
     * @param cleMessage clé du message au format 'xxxx.error.{codeErreur}'
     * @param idChamps    paramètre optionnel du message d'erreur
     */
    public FunctionnalException genereException(final String cleMessage, final Object... idChamps) {
        return new FunctionnalException(500, Integer.parseInt(StringUtils.substringAfterLast(cleMessage, ".")), messageProviderService.getMessage(cleMessage, idChamps));
    }

    /**
     * Genère une exception de type 404 avec les paramètres donnés.
     *
     * @param cleMessage clé du message au format 'xxxx.error.{codeErreur}'
     * @param idChamp    paramètre optionnel du message d'erreur
     */
    public FunctionnalException genereExceptionNotFound(final String cleMessage, final Object idChamp) {
        return new FunctionnalException(404, Integer.parseInt(StringUtils.substringAfterLast(cleMessage, ".")), messageProviderService.getMessage(cleMessage, idChamp));
    }
}
