/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.mis.vacaciones.logic.api;

import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import co.edu.uniandes.mis.vacaciones.logic.entities.EventoEntity;
import java.util.List;
/**
 *
 * @author js.gomez14
 */
public interface IEventoLogic
{
    public List<EventoEntity> getEventos();

    public EventoEntity getEvento(Long id) throws BusinessLogicException;

    public EventoEntity createEvento(EventoEntity entity) throws BusinessLogicException;

    public EventoEntity updateEvento(EventoEntity entity) throws BusinessLogicException;

    public void deleteEvento(Long id);
}
