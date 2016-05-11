/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

import co.edu.uniandes.mis.vacaciones.logic.api.IParadaLogic;
//import co.edu.uniandes.mis.vacaciones.logic.ejbs.ParadaLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.ParadaEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import edu.uniandes.lospropios.resources.converters.ParadaConverter;
import edu.uniandes.lospropios.resources.dtos.ParadaDTO;
import edu.uniandes.lospropios.resources.exceptions.ParadaLogicException;
//import edu.uniandes.lospropios.resources.mocks.ParadaLogicMock;
import javax.enterprise.context.RequestScoped;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * /**
 * Clase que implementa el recurso REST correspondiente a "parada".
 *
 * Note que la aplicación (definida en RestConfig.java) define la ruta "/api" y
 * este recurso tiene la ruta "parada". Al ejecutar la aplicación, el recurse
 * será accesibe a través de la ruta "/api/cities"
 *
 * @author mc.hernandez1
 */
@Path("paradas")
@Produces("application/json")
@RequestScoped

public class ParadaResource {

    private static final Logger logger = Logger.getLogger(ParadaResource.class.getName());
    @Inject
    private IParadaLogic paradaLogic;

    /**
     * Obtiene el listado de paradas.
     *
     * @return lista de paradas
     * @throws edu.uniandes.lospropios.resources.exceptions.ParadaLogicException
     */
    @GET
    public List<ParadaDTO> getParadas() throws ParadaLogicException {
        logger.info("Se ejecuta el metodo getParadas");
        List<ParadaEntity> paradas = paradaLogic.getParadas();
        return ParadaConverter.listEntity2DTO(paradas);
    }

    /**
     * Obtiene una parada
     * @param idParada identificador de la parada
     * @return parada encontrada
     * @throws edu.uniandes.lospropios.resources.exceptions.ParadaLogicException
     * @throws
     * co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public ParadaDTO getParada( @PathParam("idParada") Long idParada) throws ParadaLogicException, BusinessLogicException {
        logger.log(Level.INFO, "Se ejecuta metodo getParada con id={0}", idParada);
        ParadaEntity parada = paradaLogic.getParada(idParada);
        return ParadaConverter.fullEntity2DTO(parada);
    }

    /**
     * Agrega una parada
     *
     * @param dtoParada dto de parada a agregar
     * @return datos de la parada a agregar
     * @throws ParadaLogicException cuando ya existe una parada con el id
     * suministrado
     * @throws co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException
     */
    @POST
    public ParadaDTO createParada(ParadaDTO dtoParada) throws ParadaLogicException, BusinessLogicException {
        logger.info("Se ejecuta método createParada");
        ParadaEntity entity = ParadaConverter.fullDTO2Entity(dtoParada);
        ParadaEntity entityDos = paradaLogic.createParada(entity);

        return ParadaConverter.fullEntity2DTO(entityDos);
    }

    /**
     * Actualiza los datos de una parada
     *
     * @param idParada
     * @param parada parada a modificar
     * @return datos de la parada modificados
     * @throws ParadaLogicException cuando no existe una parada con el id
     * suministrado
     * @throws
     * co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public ParadaDTO updateParada(@PathParam("id") Long idParada, ParadaDTO parada) throws ParadaLogicException, BusinessLogicException {
        logger.log(Level.INFO, "Se ejecuta método updateParada con id={0}", idParada);
        ParadaEntity entity = ParadaConverter.fullDTO2Entity(parada);
        entity.setId(idParada);

        ParadaEntity savedParada = paradaLogic.updateParada(entity);
        return ParadaConverter.fullEntity2DTO(savedParada);

    }

    /**
     * Elimina los datos de una parada
     *
     * @param id identificador de la parada a eliminar
     * @throws ParadaLogicException cuando no existe una parada con el id
     * suministrado
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteParada(@PathParam("id") Long id) throws ParadaLogicException {
        paradaLogic.deleteParada(id);
    }

}
