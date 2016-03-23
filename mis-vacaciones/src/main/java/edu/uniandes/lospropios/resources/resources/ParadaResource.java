/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

import edu.uniandes.lospropios.resources.dtos.ParadaDTO;
import edu.uniandes.lospropios.resources.exceptions.ParadaLogicException;
import edu.uniandes.lospropios.resources.mocks.ParadaLogicMock;
import javax.enterprise.context.RequestScoped;

import java.util.List;

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
@Path("parada")
@Produces("application/json")
@RequestScoped

public class ParadaResource {

    @Inject
    ParadaLogicMock paradaLogic;

    /**
     * Obtiene el listado de paradas.
     *
     * @return lista de paradas
     * @throws edu.uniandes.lospropios.resources.exceptions.ParadaLogicException
     */
    @GET
    public List<ParadaDTO> getParada() throws ParadaLogicException
    {
        return paradaLogic.getParadas();
    }

    /**
     * Obtiene una parada
     *
     * @param id identificador de la parada
     * @return parada encontrada
     * @throws edu.uniandes.lospropios.resources.exceptions.ParadaLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public ParadaDTO getParada(@PathParam("id") Long id) throws ParadaLogicException
    {
        return paradaLogic.getParada(id);
    }

    /**
     * Agrega una parada
     *
     * @param parada parada a agregar
     * @return datos de la parada a agregar
     * @throws ParadaLogicException cuando ya existe una parada con el id
     * suministrado
     */
    @POST
    public ParadaDTO createParada(ParadaDTO parada) throws ParadaLogicException
    {
        return paradaLogic.createParada(parada);
    }

    /**
     * Actualiza los datos de una parada
     *
     * @param id identificador de la parada a modificar
     * @param parada parada a modificar
     * @return datos de la parada modificados
     * @throws ParadaLogicException cuando no existe una parada con el id
     * suministrado
     */
    @PUT
    @Path("{id: \\d+}")
    public ParadaDTO updateParada(@PathParam("id") Long id, ParadaDTO parada) throws ParadaLogicException
    {
        return paradaLogic.updateParada(id, parada);
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
    public void deleteParada(@PathParam("id") Long id) throws ParadaLogicException
    {
        paradaLogic.deleteParada(id);
    }

}
