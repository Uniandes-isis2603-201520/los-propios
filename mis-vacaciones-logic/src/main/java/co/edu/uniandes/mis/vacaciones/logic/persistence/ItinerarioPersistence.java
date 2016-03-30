/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.persistence;

import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jg.murillo10
 */
@Stateless
public class ItinerarioPersistence {

    private static final Logger logger = Logger.getLogger(ItinerarioPersistence.class.getName());

    @PersistenceContext(unitName = "MisVacacionesPU")
    protected EntityManager em;


    public ItinerarioEntity find(long id){
        logger.log(Level.INFO, "Consultando itinerario con id={0}", id);
        return em.find(ItinerarioEntity.class, id);

    }
    public List<ItinerarioEntity>   findAll(){
         logger.info("Consultando todos los itinerarios");
        Query q = em.createQuery("select u from ItinerarioEntity u");
        return q.getResultList();
    }
}
