package com.cbp.disponibilite.gestionnaires.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "gestionnaire")
public class Gestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_idgestionnaire")
    private Long idGestionnaire;

    @NotNull
    @Column(name = "c_matricule")
    private Long matricule;

    @NotNull
    @Column(name = "c_nom")
    private String nom;

    @NotNull
    @Column(name = "c_prenom")
    private String prenom;

    @Column(name = "f_iddomaine")
    private Long domaine;

    @Column(name = "f_idgroupe")
    private Long groupe;

    @Column(name = "c_dispo")
    private boolean dispo;

    @NotNull
    @Column(name = "c_telephone")
    private Long telephone;

    @Column(name = "c_datemodification")
    private Date dateModification;

    public Long getIdGestionnaire() {
        return idGestionnaire;
    }

    public void setIdGestionnaire(Long idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public Long getMatricule() {
        return matricule;
    }

    public void setMatricule(Long matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getDomaine() {
        return domaine;
    }

    public void setDomaine(Long domaine) {
        this.domaine = domaine;
    }

    public Long getGroupe() {
        return groupe;
    }

    public void setGroupe(Long groupe) {
        this.groupe = groupe;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
}
