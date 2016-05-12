package co.edu.uniandes.mis.vacaciones.logic.persistence;

import co.edu.uniandes.mis.vacaciones.logic.entities.ParadaEntity;

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

    private static final Logger LOGGER = Logger.getLogger(ParadaPersistence.class.getName());

    @PersistenceContext(unitName = "MisVacacionesPU")
    protected EntityManager em;

    public ParadaEntity find(long id) {

        LOGGER.log(Level.INFO, "Consultando la parada con id = {0}", id);
        return em.find(ParadaEntity.class, id);

    }

    public List<ParadaEntity> findAll() {
        LOGGER.info("Consultando todas las paradas");
        Query q = em.createQuery("select u from ParadaEntity u");
        return q.getResultList();
    }

    public ParadaEntity create(ParadaEntity entity) {
        LOGGER.info("Creando una parada");
        em.persist(entity);
        LOGGER.info("Libro creado");
        return entity;
    }

    public ParadaEntity update(ParadaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando parada con id = {0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando libro con id={0}", id);
        ParadaEntity entity = em.find(ParadaEntity.class, id);
        em.remove(entity);
    }
}
