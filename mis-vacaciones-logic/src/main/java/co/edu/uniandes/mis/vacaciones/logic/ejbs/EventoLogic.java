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
        return null;
    }

    public EventoEntity createEvento(EventoEntity entity) throws BusinessLogicException
    {
        return null;
    }

    public EventoEntity updateEvento(EventoEntity entity) throws BusinessLogicException
    {
        return null;
    }

    public void deleteEvento(Long id)
    {

    }
}