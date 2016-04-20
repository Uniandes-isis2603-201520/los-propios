/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

import co.edu.uniandes.mis.vacaciones.logic.ejbs.VisitaLogic;
//import com.sun.istack.internal.logging.Logger;
import edu.uniandes.lospropios.resources.converters.VisitaConverter;
import edu.uniandes.lospropios.resources.dtos.VisitaDTO;
import edu.uniandes.lospropios.resources.exceptions.VisitaLogicException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josedanielcardenasrincon
 */
@Path("visita")
@Produces("application/json")
@RequestScoped
public class VisitaResource {

    private static final Logger logger = Logger.getLogger(VisitaResource.class.getName());
    @Inject
    private VisitaLogic visitaLogic;

    /**
     * Obtiene el listado de itineratios.
     *
     * @return lista de visitas
     * @throws
     * edu.uniandes.lospropios.resources.exceptions.VisitaLogicException
     */
    @GET
    public List<VisitaDTO> getVisita() throws VisitaLogicException {
        return VisitaConverter.listEntity2DTO( visitaLogic.getVisitas());
    }

    /**
     * Obtiene un visita
     *
     * @param id identificador del visita
     * @return visita encontrada
     * @throws
     * edu.uniandes.lospropios.resources.exceptions.VisitaLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public VisitaDTO getVisita(@PathParam("id") Long id) throws VisitaLogicException {
        return VisitaConverter.refEntity2DTO(visitaLogic.getVisita(id));
    }

    /**
     * Agrega un visita
     *
     * @param visita visita a agregar
     * @return datos del visita a agregar
     * @throws edu.uniandes.lospropios.resources.exceptions.VisitaLogicException
     */
    @POST
    public VisitaDTO createVisita(VisitaDTO visita) throws VisitaLogicException {
        return VisitaConverter.refEntity2DTO(visitaLogic.createVisita(VisitaConverter.fullDTO2Entity(visita)));
    }

    /**
     * Actualiza los datos de un visita
     *
     * @param id identificador del visita a modificar
     * @param visita visita a modificar
     * @return datos del itinierario modificado
     * @throws VisitaLogicException cuando no existe un visita con el id
     * suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public VisitaDTO updateVisita(@PathParam("id") Long id, VisitaDTO visita) throws VisitaLogicException {
        return VisitaConverter.refEntity2DTO(visitaLogic.updateVisita(id, VisitaConverter.fullDTO2Entity(visita)));
    }

    /**
     * Elimina los datos de un visita
     *
     * @param id identificador del visita a eliminar
     * @throws VisitaLogicException cuando no existe un visita con el id
     * suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteVisita(@PathParam("id") Long id) throws VisitaLogicException {
        visitaLogic.deleteVisita(id);
    }
}
