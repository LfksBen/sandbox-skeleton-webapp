package com.cbp.disponibilite.gestionnaires.services.error.dto;

import com.cbp.disponibilite.gestionnaires.model.exceptions.FunctionnalException;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "erreur")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErreurGenesys {

       /** contains the same HTTP Status code returned by the server */
    @XmlElement
    int status;

    /** application specific error code */
    @XmlElement
    int code;

    /** message describing the error*/
    @XmlElement
    String message;

    public ErreurGenesys() {

    }

    public ErreurGenesys(FunctionnalException ex){
        this.status = ex.getStatus();
        this.code = ex.getCode();
        this.message = ex.getMessage();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
