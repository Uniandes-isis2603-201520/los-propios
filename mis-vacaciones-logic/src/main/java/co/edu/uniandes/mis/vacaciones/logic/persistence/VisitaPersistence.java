/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.persistence;

import co.edu.uniandes.mis.vacaciones.logic.entities.VisitaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author josedanielcardenasrincon
 */
@Stateless
public class VisitaPersistence {
    private static final Logger logger = Logger.getLogger(ItinerarioPersistence.class.getName());

    @PersistenceContext(unitName = "MisVacacionesPU")
    protected EntityManager em;


    public VisitaEntity find(long id){
        logger.log(Level.INFO, "Consultando ivisita con id={0}", id);
        return em.find(VisitaEntity.class, id);

    }
    public List<VisitaEntity>   findAll(){
         logger.info("Consultando todos las visitas");
        Query q = em.createQuery("select u from VisitaEntity u");
        return q.getResultList();
    }

    public void create(VisitaEntity visitaEntity) {
        logger.info("Creando una visita");
        em.persist(visitaEntity);
    }

    public VisitaEntity update(VisitaEntity visitaEntity) {
        return em.merge(visitaEntity);
    }

    public void delete(Long id) {
        VisitaEntity visita= em.find(VisitaEntity.class, id);
        em.remove(visita);
        
    }
}
