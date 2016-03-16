/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *need a change
 */
package edu.uniandes.lospropios.resources.resources;

import edu.uniandes.lospropios.resources.dtos.CiudadDTO;
import edu.uniandes.lospropios.resources.exceptions.CiudadLogicException;
import edu.uniandes.lospropios.resources.mocks.CiudadLogicMock;
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

@Path("ciudades")
@Produces("application/json")
@RequestScoped
public class CiudadResource {

    @Inject
    CiudadLogicMock cityLogic;

    @GET
    public List<CiudadDTO> getCities() throws CiudadLogicException {
        return cityLogic.getCities();
    }

    @GET
    @Path("{id: \\d+}")
    public CiudadDTO getCity(@PathParam("id") Long id) throws CiudadLogicException {
        return cityLogic.getCity(id);
    }

    @POST
    public CiudadDTO createCity(CiudadDTO city) throws CiudadLogicException {
        return cityLogic.createCity(city);
    }

    @PUT
    @Path("{id: \\d+}")
    public CiudadDTO updateCity(@PathParam("id") Long id, CiudadDTO city) throws CiudadLogicException {
        return cityLogic.updateCity(id, city);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteCity(@PathParam("id") Long id) throws CiudadLogicException {
        cityLogic.deleteCity(id);
    }

}
