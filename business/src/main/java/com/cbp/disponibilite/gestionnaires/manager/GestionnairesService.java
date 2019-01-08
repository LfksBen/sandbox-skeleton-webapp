package com.cbp.disponibilite.gestionnaires.manager;

import com.cbp.disponibilite.gestionnaires.dao.GestionnaireDAO;
import com.cbp.disponibilite.gestionnaires.model.entities.Gestionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GestionnairesService {

    @Autowired
    GestionnaireDAO gestionnaireDAO;

    @Transactional
    public List<Gestionnaire> getGestionnaireByMatricule(final Long matricule) {
        return gestionnaireDAO.findGestionnaire(matricule);
    }
}
