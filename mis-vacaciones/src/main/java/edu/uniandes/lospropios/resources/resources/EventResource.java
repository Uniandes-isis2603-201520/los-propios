/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

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
    EventoLogicMock eventoLogic;


    @GET
    public List<EventoDTO> getEventos() throws EventoLogicException {
        return eventoLogic.getEventos();
    }

    @GET
     @Path("{id: \\d+}")
    public EventoDTO getEvento(@PathParam("id") Long id) throws EventoLogicException {
        return eventoLogic.getEvento(id);
    }

    @POST
    public EventoDTO createEvento(EventoDTO evento) throws EventoLogicException {
        return eventoLogic.createEvento(evento);
    }

    @PUT
    @Path("{id: \\d+}")
    public EventoDTO updateEvento(@PathParam("id") Long id, EventoDTO evento) throws EventoLogicException {
        return eventoLogic.updateEvento(id, evento);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteEvento(@PathParam("id") Long id) throws EventoLogicException {
        eventoLogic.deleteEvento(id);
    }
}
