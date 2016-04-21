/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.mis.vacaciones.logic.ejbs;

import co.edu.uniandes.mis.vacaciones.logic.api.IEventoLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.EventoEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.mis.vacaciones.logic.persistence.EventoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author js.gomez14
 */
@Stateless
public class EventoLogic implements IEventoLogic
{
    private static final Logger logger = Logger.getLogger(EventoLogic.class.getName());

    @Inject
    private EventoPersistence persistence;

    public List<EventoEntity> getEventos()
    {
        logger.info("Inicia proceso de consultar todos los eventos");
        List<EventoEntity> eventos = persistence.findAll();
        logger.info("Termina proceso de consultar todos los eventos");
        return eventos;
    }

    public EventoEntity getEvento(Long id) throws BusinessLogicException
    {
        logger.log(Level.INFO, "Inicia proceso de consultar evento con id = {0}", id);
        EventoEntity evento = persistence.find(id);

        if (evento == null) {
            logger.log(Level.SEVERE, "El evento con el id {0} no existe", id);
            throw new BusinessLogicException("La evento solicitada no existe");
        }

        logger.log(Level.INFO, "Termina proceso de consultar evento con id = {0}", id);

        return evento;
    }

    public EventoEntity createEvento(EventoEntity entity) throws BusinessLogicException
    {
        logger.info("Inicia proceso de creación de evento");
        if (!validateId(entity.getId())) {
            throw new BusinessLogicException("El Id es inválido");
        }
        persistence.create(entity);
        logger.info("Termina proceso de creación de evento");
        return entity;
    }

    private boolean validateId(Long id) {
        if (id == null) {
            return false;
        }
        return true;
    }

    public EventoEntity updateEvento(EventoEntity entity) throws BusinessLogicException
    {
        logger.log(Level.INFO, "Inicia proceso de actualizar evento con id = {0}", entity.getId());
        EventoEntity newEntity = persistence.update(entity);
        logger.log(Level.INFO, "Termina proceso de actualizar evento con id={0}", entity.getId());
        return newEntity;
    }

    public void deleteEvento(Long id)
    {
        logger.log(Level.INFO, "Inicia proceso de borrar evento con id = {0}", id);
        persistence.delete(id);
        logger.log(Level.INFO, "Temrmina proceso de borrar evento con id ={0}", id);
    }

    @Override
    public EventoEntity getEventoUsuario(Long idPerfil, Long idItinerario, Long idParada, Long idVisita) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}