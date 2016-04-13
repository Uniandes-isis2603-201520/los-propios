/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.persistence;

import co.edu.uniandes.mis.vacaciones.logic.entities.PerfilEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hj.calderon10
 */
@Stateless
public class PerfilPersistence {
private static final Logger LOGGER = Logger.getLogger(PerfilPersistence.class.getName());

    @PersistenceContext(unitName = "MisVacacionesPU")
    protected EntityManager em;

    public PerfilEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando perfil con id={0}", id);
        return em.find(PerfilEntity.class, id);
    }

    public List<PerfilEntity> findAll() {
        LOGGER.info("Consultando todos los perfiles");
        Query q = em.createQuery("select u from PerfilEntity u");
        return q.getResultList();
    }

    public PerfilEntity create(PerfilEntity entity) {
        LOGGER.info("Creando un perfil nuevo");
        em.persist(entity);
        LOGGER.info("Perfil creado");
        return entity;
    }

    public PerfilEntity update(PerfilEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Perfil con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando perfil con id={0}", id);
        PerfilEntity entity = em.find(PerfilEntity.class, id);
        em.remove(entity);
    }
}
