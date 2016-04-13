/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.ejbs;

import co.edu.uniandes.mis.vacaciones.logic.api.IPerfilLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import co.edu.uniandes.mis.vacaciones.logic.entities.PerfilEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.mis.vacaciones.logic.persistence.ItinerarioPersistence;
import co.edu.uniandes.mis.vacaciones.logic.persistence.PerfilPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author hj.calderon10
 */
@Stateless
public class PerfilLogic implements IPerfilLogic {

    private final static Logger LOGGER = Logger.getLogger(PerfilLogic.class.getName());

    @Inject
    private PerfilPersistence persistence;

    @Inject
    private ItinerarioPersistence itinerarioPersistence;

    @Override
    public List<PerfilEntity> getPerfiles() {
        LOGGER.info("Inicia proceso de consultar todos los perfiles");
        List<PerfilEntity> books = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los perfiles");
        return books;
    }

    @Override
    public PerfilEntity getPerfil(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un perfil con id={0}", id);
        PerfilEntity perfil = persistence.find(id);
        if (perfil == null) {
            LOGGER.log(Level.SEVERE, "El perfil con el id {0} no existe", id);
            throw new IllegalArgumentException("El perfil solicitado no existe");
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar perfil con id={0}", id);
        return perfil;
    }

    @Override
    public PerfilEntity createPerfil(PerfilEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de perfil");
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de perfil");
        return entity;
    }

    @Override
    public PerfilEntity updatePerfil(PerfilEntity entity) throws BusinessLogicException {
        PerfilEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar perfil con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deletePerfil(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar perfil con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar perfil con id={0}", id);
    }

    @Override
    public List<ItinerarioEntity> getItinerarios(Long perfilId) {
        return getPerfil(perfilId).getItinerarios();
    }

    @Override
    public ItinerarioEntity getItinerario(Long perfilId, Long itinerarioId) {
        List<ItinerarioEntity> itinerarios = getPerfil(perfilId).getItinerarios();
        ItinerarioEntity itinerarioEntity = itinerarioPersistence.find(itinerarioId);
        if (itinerarioEntity == null) {
            throw new IllegalArgumentException("El itinerario no existe");
        }
        int index = itinerarios.indexOf(itinerarioEntity);
        if (index >= 0) {
            return itinerarios.get(index);
        }
        throw new IllegalArgumentException("El itinerario no está asociado al libro");
    }

    @Override
    public ItinerarioEntity addItinerario(Long perfilId, Long itinerarioId) throws BusinessLogicException {
        PerfilEntity perfilEntity = getPerfil(perfilId);
        ItinerarioEntity itinerarioEntity = itinerarioPersistence.find(itinerarioId);
        if (itinerarioEntity == null) {
            throw new IllegalArgumentException("El perfil no existe");
        }
        perfilEntity.getItinerarios().add(itinerarioEntity);
        return itinerarioEntity;
    }

    @Override
    public void removeItinerario(Long perfilId, Long itinerarioId) {
        PerfilEntity perfilEntity = getPerfil(perfilId);
        ItinerarioEntity itinerarioEntity = itinerarioPersistence.find(itinerarioId);
        if (itinerarioEntity == null) {
            throw new IllegalArgumentException("El itinerario no existe");
        }
    }

}
