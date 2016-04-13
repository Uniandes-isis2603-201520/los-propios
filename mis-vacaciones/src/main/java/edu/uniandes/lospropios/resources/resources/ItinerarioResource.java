/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

import co.edu.uniandes.mis.vacaciones.logic.ejbs.ItinerarioLogic;
import edu.uniandes.lospropios.resources.converters.ItinerarioConverter;
import edu.uniandes.lospropios.resources.dtos.ItinerarioDTO;
import edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException;
//import edu.uniandes.lospropios.resources.mocks.ItinerarioLogicMock;
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
 * Clase que implementa el recurso REST correspondiente a "itinerario".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "cities". Al ejecutar la aplicación, el recurse
 * será accesibe a través de la ruta "/api/cities"
 *
 * @author Asistente
 */
@Path("perfilesUsuario/{idPerfilUsuario}/itinerarios")
@Produces("application/json")
@RequestScoped
public class ItinerarioResource {


    //Modificar ItinerarioLogicMock a ItinerarioLogic
    @Inject
    ItinerarioLogic itinerarioLogic;

    ItinerarioConverter converter;
    /**
     * Obtiene el listado de itineratios.
     *
     * @return lista de itinerarios
     * @throws
     * edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException
     */
    @GET
    public List<ItinerarioDTO> getItinerario() throws ItinerarioLogicException {
        //TODO usar convertidor
        return null;
//        return itinerarioLogic.getItinerarios();
    }

    /**
     * Obtiene un itinerario
     *
     * @param idPerfil identificador del viajero
     * @param idItinerario   identificador del itinerario
     * @return itinerario encontrada
     * @throws
     * edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public ItinerarioDTO getItinerario(@PathParam("idPerfil") Long idPerfil, @PathParam("idItinerario") Long idItinerario) throws ItinerarioLogicException {
//        return itinerarioLogic.getItinerarioUsuario(idPerfil, idItinerario);
        return null;
    }

    /**
     * Agrega un itinerario
     *
     * @param itinerario itinerario a agregar
     * @return datos del itinerario a agregar
     * @throws edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException
     */
    @POST
    public ItinerarioDTO createItinerario(ItinerarioDTO itinerario) throws ItinerarioLogicException {
//        return itinerarioLogic.createItinerario(itinerario);
        return null;
    }

    /**
     * Actualiza los datos de un itinerario
     *
     * @param id identificador del itinerario a modificar
     * @param itinerario itinerario a modificar
     * @return datos del itinierario modificado
     * @throws ItinerarioLogicException cuando no existe un itinerario con el id
     * suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public ItinerarioDTO updateItinerario(@PathParam("id") Long id, ItinerarioDTO itinerario) throws ItinerarioLogicException {
//        return itinerarioLogic.updateItinerario(id, itinerario);
        return null;
    }

    /**
     * Elimina los datos de un itinerario
     *
     * @param id identificador del itinerario a eliminar
     * @throws ItinerarioLogicException cuando no existe un itinerario con el id
     * suministrado
     */
//    @DELETE
//    @Path("{id: \\d+}")
//    public void deleteItinerario(@PathParam("id") Long id) throws ItinerarioLogicException {
//        itinerarioLogic.deleteItinerario(id);
//    }

}
