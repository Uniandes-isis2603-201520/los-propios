/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.ejbs;

import co.edu.uniandes.mis.vacaciones.logic.entities.VisitaEntity;
import co.edu.uniandes.mis.vacaciones.logic.persistence.VisitaPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author josedanielcardenasrincon
 */
@Stateless
public class VisitaLogic {
    private static final Logger logger = Logger.getLogger(VisitaLogic.class.getName());
@Inject
private VisitaPersistence persistence;

    public List<VisitaEntity> getVisitas(){
    logger.info("Inicia proceso de consultar todas las visitas");
        List<VisitaEntity> visitas = persistence.findAll();
        logger.info("Termina proceso de consultar todas las visitas");
        return visitas;
}

    public VisitaEntity getVisita(Long id) {
        VisitaEntity visita=persistence.find(id);
        return visita;
    }

    public VisitaEntity createVisita(VisitaEntity visitaEntity) {
        persistence.create(visitaEntity);
        return visitaEntity;
    }

    public VisitaEntity updateVisita(Long id, VisitaEntity visitaEntity) {
        VisitaEntity entity=persistence.update(visitaEntity);
        return entity;
    }

    public void deleteVisita(Long id) {
        persistence.delete(id);
    }

}
