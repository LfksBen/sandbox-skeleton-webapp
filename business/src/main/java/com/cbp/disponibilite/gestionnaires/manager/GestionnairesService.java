package com.cbp.disponibilite.gestionnaires.manager;

import com.cbp.disponibilite.gestionnaires.dao.GestionnaireDAO;
import com.cbp.disponibilite.gestionnaires.model.entities.Gestionnaire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GestionnairesService {

    private final static Logger LOG = LoggerFactory.getLogger(GestionnairesService.class);

    @Autowired
    GestionnaireDAO gestionnaireDAO;


    @Transactional
    public List<Gestionnaire> getGestionnaireByMatricule(final Long matricule) {
        LOG.info("HELLOOOO");

        return gestionnaireDAO.findGestionnaire(matricule);
    }
}
