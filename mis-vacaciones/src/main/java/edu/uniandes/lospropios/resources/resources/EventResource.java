/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

import co.edu.uniandes.mis.vacaciones.logic.api.IEventoLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.EventoEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import edu.uniandes.lospropios.resources.converters.EventoConverter;
import edu.uniandes.lospropios.resources.dtos.EventoDTO;
import edu.uniandes.lospropios.resources.exceptions.EventoLogicException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 *
 * @author js.gomez14
 */

@Path("perfilesUsuario/{idPerfilUsuario}/itinerarios/(idItinerario)/paradas/(idParada)/visitas/(idVisita)/eventos")
@Produces("application/json")
@RequestScoped
public class EventResource
{
     private static final Logger logger = Logger.getLogger(EventResource.class.getName());

    @Inject
    private IEventoLogic eventoLogic;


    /**
     * Obtiene la lista de los registros de Mis-Vacaciones.
     *
     * @return Colección de objetos de EventoDTO (representación full)
     * @generated
     */
    @GET
    public List<EventoDTO> getEventos() {
        return EventoConverter.listEntity2DTO(eventoLogic.getEventos());
    }

    /**
     * Obtiene los datos de un objeto de Mis-Vacaciones a partir de su ID.
     *
     * @param id Identificador del objeto a consultar
     * @return Instancia de EventoDTO (representación full)
     * @throws co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException
     * @throws edu.uniandes.lospropios.resources.exceptions.EventoLogicException
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public EventoDTO getEvento(@PathParam("id") Long id) throws BusinessLogicException, EventoLogicException
    {
        return EventoConverter.fullEntity2DTO(eventoLogic.getEvento(id));
    }

     /**
     * Obtiene un evento
     *
     * @param idPerfil identificador del perfil
     * @param idItinerario identificador del itinerario
     * @param idParada identificador de la parada
     * @param idVisita identificador de la visita
     * @return evento encontrado
     * @throws edu.uniandes.lospropios.resources.exceptions.EventoLogicException
     * @throws co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public EventoDTO getEventoUsuario(@PathParam("idPerfil") Long idPerfil, @PathParam("idItinerario") Long idItinerario, @PathParam("idParada") Long idParada, @PathParam("idVisita") Long idVisita) throws EventoLogicException, BusinessLogicException {
        logger.log(Level.INFO, "Se ejecuta metodo getEvento con id={0}", idPerfil);
        EventoEntity evento= eventoLogic.getEventoUsuario(idPerfil, idItinerario, idParada, idVisita);
        return EventoConverter.fullEntity2DTO(evento);
    }

    /**Retorna una actividad especificando usuario, itinerario, parada,**/

    /**
     * Agrega un evento
     *
     * @param dtoEvento dto de evento a agregar
     * @return datos del evento a agregar
     * @throws EventoLogicException cuando ya existe un evento con el id
     * suministrado
     */
    @POST
    public EventoDTO createEvento(EventoDTO dtoEvento) throws EventoLogicException, BusinessLogicException {
        logger.info("Se ejecuta método createEvento");
        EventoEntity entity = EventoConverter.fullDTO2Entity(dtoEvento);
        EventoEntity entityDos = eventoLogic.createEvento(entity);

        return EventoConverter.fullEntity2DTO(entityDos);
    }

    @POST
    //TODO AGREGAR EVENTO A UNA VISITA


     /**
     * Actualiza los datos de un Evento
     *
     * @param id identificador del evento a modificar
     * @param evento parada a modificar
     * @return datos del evento modificados
     * @throws EventoLogicException cuando no existe un evento con el id suministrado
     * @throws co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public EventoDTO updateEvento(@PathParam("id") Long idEvento, EventoDTO parada) throws EventoLogicException, BusinessLogicException {
        logger.log(Level.INFO, "Se ejecuta método updateEvento con id={0}", idEvento);
        EventoEntity entity = EventoConverter.fullDTO2Entity(parada);
        entity.setId(idEvento);

        EventoEntity savedParada = eventoLogic.updateEvento(entity);
        return EventoConverter.fullEntity2DTO(savedParada);
    }

    /**
     * Elimina los datos de un evento.
     * @param id identificador del evento a eliminar
     * @throws EventoLogicException cuando no existe un evento con el id suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEvento(@PathParam("id") Long id) throws EventoLogicException {
        eventoLogic.deleteEvento(id);
    }
}