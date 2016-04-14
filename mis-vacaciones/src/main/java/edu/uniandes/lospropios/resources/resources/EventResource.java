/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

import co.edu.uniandes.mis.vacaciones.logic.ejbs.EventoLogic;
import edu.uniandes.lospropios.resources.dtos.EventoDTO;
import edu.uniandes.lospropios.resources.exceptions.EventoLogicException;
import edu.uniandes.lospropios.resources.mocks.EventoLogicMock;
import java.util.List;
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

@Path("eventos")
@Produces("application/json")
@RequestScoped
public class EventResource
{

    @Inject
    EventoLogic eventoLogic;


    /**Retorna el catalogo de actividades completo**/
    @GET
    public List<EventoDTO> getEventos() throws EventoLogicException {
       // return eventoLogic.getEventos();
       return null;
    }

    /**Retorna una actividad del catalogo de actividades dado el identificador**/
    @GET
    @Path("{id: \\d+}")
    public EventoDTO getEvento(@PathParam("id") Long id) throws EventoLogicException {
        //return eventoLogic.getEvento(id);
        return null;
    }

    /**Retorna una actividad especificando usuario, itinerario, parada,**/

    @POST
    public EventoDTO createEvento(EventoDTO evento) throws EventoLogicException {
        //return eventoLogic.createEvento(evento);
        return null;
    }

    @PUT
    @Path("{id: \\d+}")
    public EventoDTO updateEvento(@PathParam("id") Long id, EventoDTO evento) throws EventoLogicException {
        //return eventoLogic.updateEvento(id, evento);
        return null;
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteEvento(@PathParam("id") Long id) throws EventoLogicException {
        eventoLogic.deleteEvento(id);
    }
}
