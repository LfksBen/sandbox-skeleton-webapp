package com.cbp.disponibilite.gestionnaires.dao;

import com.cbp.disponibilite.gestionnaires.model.entities.Gestionnaire;
import javafx.util.Pair;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class GestionnaireDAO extends AbstractDAO<Long, Gestionnaire> {

    public String hello() {
        Gestionnaire gestionnaire = new Gestionnaire();
        gestionnaire.setDispo(true);
        gestionnaire.setDomaine(1l);
        gestionnaire.setGroupe(1l);
        gestionnaire.setMatricule(1234l);
        gestionnaire.setNom("NOM");
        gestionnaire.setPrenom("PRENOM");
        gestionnaire.setTelephone(1234l);
        gestionnaire.setDateModification(new Date());

        this.persist(gestionnaire, true);

        return "hello";
    }

    public List<Gestionnaire> findGestionnaire(final Long matricule) {
        return this.queryResultList(
                "FROM " + Gestionnaire.class.getSimpleName()
                        + " WHERE matricule = :matricule"
                        + " ORDER BY nom, prenom DESC",
                new Pair<>("matricule", matricule)
        );
    }
}
