/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

import co.edu.uniandes.mis.vacaciones.logic.api.IItinerarioLogic;
import co.edu.uniandes.mis.vacaciones.logic.ejbs.ItinerarioLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.ItinerarioEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import edu.uniandes.lospropios.resources.converters.ItinerarioConverter;
import edu.uniandes.lospropios.resources.dtos.ItinerarioDTO;
import edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException;
//import edu.uniandes.lospropios.resources.mocks.ItinerarioLogicMock;
import java.util.List;
import java.util.logging.Level;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
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


     private static final Logger logger = Logger.getLogger(ItinerarioResource.class.getName());

    //Modificar ItinerarioLogicMock a ItinerarioLogic
    @Inject
    private IItinerarioLogic itinerarioLogic;

    /**
     * Obtiene el listado de itineratios.
     *
     * @return lista de itinerarios
     * @throws
     * edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException
     */
    @GET
    public List<ItinerarioDTO> getItinerarios() throws ItinerarioLogicException {
        logger.info("Se ejecuta el metodo getItinerarios");
        List<ItinerarioEntity> itinerarios = itinerarioLogic.getItinerarios();
        return ItinerarioConverter.listEntity2DTO(itinerarios);
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
        logger.log(Level.INFO, "Se ejecuta metodo getItinerario con id={0}", idPerfil);
        ItinerarioEntity itinerario= itinerarioLogic.getItinerarioUsuario(idPerfil, idItinerario);
        return ItinerarioConverter.fullEntity2DTO(itinerario);
    }

    /**
     * Agrega un itinerario
     *
     * @param itinerario itinerario a agregar
     * @return datos del itinerario a agregar
     * @throws edu.uniandes.lospropios.resources.exceptions.ItinerarioLogicException
     */
    @POST
//    @StatusCreated
    public ItinerarioDTO createItinerario(ItinerarioDTO dto) throws ItinerarioLogicException {
//        return itinerarioLogic.createItinerario(itinerario);
     logger.info("Se ejecuta método createBook");
        ItinerarioEntity entity = ItinerarioConverter.fullDTO2Entity(dto);
//        ItinerarioEntity newEntity = ItinerarioLogic.createItinerario(entity);
        ItinerarioEntity newEntity = itinerarioLogic.createItinerario(entity);
//        } catch (BusinessLogicException ex) {
//            logger.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
//            throw new WebApplicationException(ex.getLocalizedMessage(), ex, Response.Status.BAD_REQUEST);
//        }
        return ItinerarioConverter.fullEntity2DTO(newEntity);
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
    public ItinerarioDTO updateItinerario(@PathParam("idPerfil") Long idPerfil, @PathParam("idItinerario") Long idItinerario, ItinerarioDTO itinerario) throws ItinerarioLogicException {
//        return itinerarioLogic.updateItinerario(id, itinerario);
         logger.log(Level.INFO, "Se ejecuta método updateBook con id={0}", idItinerario);
        ItinerarioEntity entity = ItinerarioConverter.fullDTO2Entity(itinerario);
        entity.setId(idItinerario);
        // estos comentarios se usan para asociar a itinerarios las paradas
//        ItinerarioEntity oldEntity = itinerarioLogic.getItinerarioUsuario(idPerfil, idItinerario);
//        entity.setParadas(oldEntity.getParadas());
            ItinerarioEntity savedItinerario = itinerarioLogic.updateItinerario(idItinerario, entity);
            return ItinerarioConverter.fullEntity2DTO(savedItinerario);

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
