/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.ejbs;

import co.edu.uniandes.mis.vacaciones.logic.api.IParadaLogic;

import co.edu.uniandes.mis.vacaciones.logic.entities.VisitaEntity;

import co.edu.uniandes.mis.vacaciones.logic.entities.ParadaEntity;

import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;

import co.edu.uniandes.mis.vacaciones.logic.persistence.VisitaPersistence;

import co.edu.uniandes.mis.vacaciones.logic.persistence.ParadaPersistence;

import java.util.Date;

import java.util.List;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.ejb.Stateless;

import javax.inject.Inject;

/**
 *
 * @author mc.hernandez1
 */
@Stateless

public class ParadaLogic implements IParadaLogic {

    private static final Logger logger = Logger.getLogger(ParadaLogic.class.getName());

    @Inject
    private ParadaPersistence persistence;

    @Inject
    private VisitaPersistence visitaPersistence;

    @Override
    public List<ParadaEntity> getParadas() {
        logger.info("Inicia el proceso de consultar todas las paradas");
        List<ParadaEntity> paradas = persistence.findAll();
        logger.info("Termina proceso de consultar todos las paradas");
        return paradas;
    }

    @Override
    public ParadaEntity getParada(Long id) throws BusinessLogicException {
        logger.log(Level.INFO, "Inicia proceso de consultar parada con id = {0}", id);
        ParadaEntity parada = persistence.find(id);

        if (parada == null) {
            logger.log(Level.SEVERE, "La parada con el id {0} no existe", id);
            throw new BusinessLogicException("La parada solicitada no existe");

        }

        logger.log(Level.INFO, "Termina proceso de consultar parada con id = {0}", id);

        return parada;
    }

    @Override
    public ParadaEntity createParada(ParadaEntity entity) throws BusinessLogicException {
        logger.info("Inicia proceso de creación de parada");
        if (!validateId(entity.getId())) {
            throw new BusinessLogicException("El Id es inválido");
        }
        persistence.create(entity);
        logger.info("Termina proceso de creación de parada");
        return entity;
    }

    @Override
    public ParadaEntity updateParada(ParadaEntity entity) throws BusinessLogicException {
        logger.log(Level.INFO, "Inicia proceso de actualizar parada con id = {0}", entity.getId());
        ParadaEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar parada con id={0}", entity.getId());
        return newEntity;
    }

    @Override
    public void deleteParada(Long id) {
        logger.log(Level.INFO, "Inicia proceso de borrar parada con id = {0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Temrmina proceso de borrar parada con id ={0}", id);

    }

    @Override
    public List<VisitaEntity> getVisitas(Long visitaId) {
        return persistence.find(visitaId).getVisitas();
    }

    @Override
    public VisitaEntity getVisita(Long paradaId, Long visitaId) {
        List<VisitaEntity> visitas = persistence.find(paradaId).getVisitas();
        VisitaEntity visitaEntity = new VisitaEntity();
        visitaEntity.setId(visitaId);
        int index = visitas.indexOf(visitaEntity);
        if (index >= 0) {
            return visitas.get(index);
        }
        return null;
    }

    @Override
    public VisitaEntity addVisita(Long visitaId, Long paradaId) throws BusinessLogicException {
        ParadaEntity paradaEntity = persistence.find(paradaId);
        VisitaEntity visitaEntity = visitaPersistence.find(visitaId);
        VisitaEntity visitaEntityDos = new VisitaEntity();
        if (visitaEntity == visitaEntityDos) {
            if (!visitaAntesDeParada(visitaEntity.getFecha(), paradaEntity.getFechaInicioParada()));
            {
                throw new BusinessLogicException("La fecha de visita no puede ser anterior a la fecha en que se creo la parada");
            }
        }
        paradaEntity.getVisitas().add(visitaEntity);
        return visitaEntity;
    }

    @Override
    public void removeVisita(Long visitaId, Long paradaId) {
        ParadaEntity paradaEntity = persistence.find(paradaId);
        VisitaEntity visitaEntity = new VisitaEntity();
        visitaEntity.setId(visitaId);
        paradaEntity.getVisitas().remove(visitaEntity);
    }

    @Override
    public List<VisitaEntity> replaceVisitas(List<VisitaEntity> visitas, Long paradaId) throws BusinessLogicException {
        ParadaEntity paradaEntity = persistence.find(paradaId);
        paradaEntity.setVisitas(visitas);
        for (VisitaEntity visita : visitas) {
            if (!visitaAntesDeParada(visita.getFecha(), paradaEntity.getFechaInicioParada())) {
                throw new BusinessLogicException("La fecha de visita no puede ser anterior a la fecha en que se creo la parada");
            }
        }
        return paradaEntity.getVisitas();
    }

    private boolean validateId(Long id) {
        return id != null;
    }

    private boolean visitaAntesDeParada(Date fechaInicioVisita, Date fechaInicioParada) {

        if (fechaInicioParada != null && fechaInicioVisita != null && fechaInicioVisita.before(fechaInicioParada)) {
            {
                return true;
            }
        }
        return false;
    }

}
