package com.cbp.disponibilite.gestionnaires.model.exceptions;

/**
 * Created by BRAUD on 28/11/2017.
 *
 * Permet de déterminer côté front si l'erreur est affichage ou non, <br/>
 * typiquement une erreur fonctionnelle (message à l'utilisateur) ou une erreur technique (NullPointer -> on ne remonte pas cette infos)
 */
public class FunctionnalException extends Exception {

    /**
     * contains redundantly the HTTP status of the response sent back to the client in case of error, so that
     * the developer does not have to look into the response headers. If null a default
     */
    private final Integer status;

    /** application specific error code */
    private final int code;

    /**
     * Build a new Exception
     * @param status The status code
     * @param code Application Error Code
     * @param message Message
     */
    public FunctionnalException(int status, int code, String message) {
        super(message);
        this.status = status;
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

}
