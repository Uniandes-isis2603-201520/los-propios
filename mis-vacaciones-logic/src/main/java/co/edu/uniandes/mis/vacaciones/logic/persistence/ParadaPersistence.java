/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mc.hernandez1
 */
@Stateless
public class ParadaPersistence {

    private static final Logger logger = Logger.getLogger(ParadaPersistence.getName());

    //Verificar que sea el nombre de la unitName
    @PersistenceContext(unitName = "MisVacacionesPU")
    protected EntityManager em;

    public ParadaEntity find(Long id) {

        logger.info(Level.INFO, "Consultando la parada con id = {0}", id);
        return em.find(ParadaEntity.class, id);

    }

    public List<ParadaEntity> findAll() {
        logger.info("Consultando todas las paradas");
        Query q = em.createQuery("select u from ParadaEntity u");
        return q.getResultList();
    }

public ParadaEntity create(ParadaEntity entity)
{
    logger.info("Creando una parada");
    em.persist(entity);
    logger.info("Libro creado");
    return entity;
}
public ParadaEntity update(ParadaEntity entity)
{
    logger.log(Level.INFO, "Actualizando parada con id = {0}", entity.getId());
    return em.merge(entity);
}

public void delete(Long id)
{
    logger.log(Level.INFO,"Borrando libro con id={0}", id);
    ParadaEntity entity = em.find(ParadEntity.class, id);
    em.remove(entity);
}
