package com.cbp.disponibilite.gestionnaires.model.exceptions;

/**
 * Created by BRAUD on 28/11/2017.
 *
 * Permet de déterminer côté front si l'erreur est affichage ou non, <br/>
 * typiquement une erreur fonctionnelle (message à l'utilisateur) ou une erreur technique (NullPointer -> on ne remonte pas cette infos)
 */
public class TechnicalException extends Exception {
    public TechnicalException() {
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalException(Throwable cause) {
        super(cause);
    }

    public TechnicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
