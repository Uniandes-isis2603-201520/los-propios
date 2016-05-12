/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

import co.edu.uniandes.mis.vacaciones.logic.api.IItinerarioLogic;
import co.edu.uniandes.mis.vacaciones.logic.api.IPerfilLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import edu.uniandes.lospropios.resources.converters.ItinerarioConverter;
import edu.uniandes.lospropios.resources.dtos.ItinerarioDTO;
import edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;

/**
 * Clase que implementa el recurso REST correspondiente a "itinerario".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "cities". Al ejecutar la aplicación, el recurse
 * será accesibe a través de la ruta "/api/cities"
 *
 * @author Asistente
 */
@Path("perfilesUsuario/{perfilId}/itinerarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ItinerarioResource {

    private static final Logger logger = Logger.getLogger(ItinerarioResource.class.getName());

    //Modificar ItinerarioLogicMock a ItinerarioLogic
    @Inject
    private IItinerarioLogic itinerarioLogic;

    @Inject
    private IPerfilLogic perfilLogic;

    /**
     * Obtiene el listado de itineratios.
     *
     * @return lista de itinerarios
     * @throws
     * edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException
     */
    @GET
    public List<ItinerarioDTO> getItinerarios(@PathParam("perfilId") Long id) throws ItinerarioLogicException {
        logger.info("Se ejecuta el metodo getItinerarios");
        List<ItinerarioEntity> itinerarios = itinerarioLogic.getItinerarios(id);
        logger.info("La lista de its es: " + itinerarios.isEmpty());
        List<ItinerarioDTO> x = ItinerarioConverter.listEntity2DTO(itinerarios);
        logger.info("La lista DTO es: " + x.isEmpty());
        return x;
    }

    /**
     * Obtiene un itinerario
     *
     * @param idItinerario identificador del itinerario
     * @return itinerario encontrada
     * @throws
     * edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public ItinerarioDTO getItinerario(@PathParam("perfilId") Long id, @PathParam("id") Long idIter) throws ItinerarioLogicException {
        ItinerarioEntity itinerario = itinerarioLogic.getItinerario(id, idIter);
        return ItinerarioConverter.fullEntity2DTO(itinerario);
    }

    /**
     * Agrega un itinerario
     *
     * @param dto itinerario a agregar
     * @return datos del itinerario a agregar
     * @throws
     * edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException
     * @throws
     * co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException
     */
    @POST
    public ItinerarioDTO createItinerario(@PathParam("perfilId") Long perfilId, ItinerarioDTO dto) throws ItinerarioLogicException, BusinessLogicException {
        ItinerarioEntity entity = ItinerarioConverter.fullDTO2Entity(dto);
        entity = itinerarioLogic.createItinerario(perfilId, entity);
        perfilLogic.addItinerario(perfilId, entity);
        return ItinerarioConverter.fullEntity2DTO(entity);
    }

    /**
     * Actualiza los datos de un itinerario
     *
     * @param idItinerario
     * @param itinerario itinerario a modificar
     * @return datos del itinierario modificado
     * @throws ItinerarioLogicException cuando no existe un itinerario con el id
     * suministrado
     * @throws
     * co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public ItinerarioDTO updateItinerario(@PathParam("perfilId") Long idItinerario,@PathParam("id") Long iterId, ItinerarioDTO itinerario) throws ItinerarioLogicException, BusinessLogicException {
        ItinerarioEntity entity = ItinerarioConverter.fullDTO2Entity(itinerario);
        entity.setId(iterId);
        entity = itinerarioLogic.updateItinerario(iterId, entity);
        return ItinerarioConverter.fullEntity2DTO(entity);

    }

    /**
     * Elimina los datos de un itinerario
     *
     * @param id identificador del itinerario a eliminar
     * @throws ItinerarioLogicException cuando no existe un itinerario con el id
     * suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteItinerario(@PathParam("perfilId") Long id, @PathParam("id") Long idIter) throws ItinerarioLogicException {
        itinerarioLogic.deleteItinerario(id, idIter);
    }

}
