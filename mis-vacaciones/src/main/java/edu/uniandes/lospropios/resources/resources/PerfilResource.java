/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

import edu.uniandes.lospropios.resources.dtos.PerfilDTO;
import edu.uniandes.lospropios.resources.exceptions.PerfilLogicException;
import edu.uniandes.lospropios.resources.mocks.PerfilLogicMock;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;



@Path("perfilUsuario")
@Produces("application/json")
@RequestScoped
public class PerfilResource {


    @Inject
    PerfilLogicMock perfilLogic;

    @GET
    public String getPerfil() throws PerfilLogicException {
        return perfilLogic.getPerfil();
    }

    @POST
    public PerfilDTO createPerfil(PerfilDTO perfil) throws PerfilLogicException
    {
        return perfilLogic.createPerfil(perfil);
    }

    @PUT
    @Path("{id: \\d+}")
    public PerfilDTO updatePerfil(@PathParam("id") Long id, PerfilDTO perfil) throws PerfilLogicException
    {
        return perfilLogic.updatePerfil(id, perfil);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteCity(@PathParam("id") Long id) throws PerfilLogicException {
        perfilLogic.deletePerfil(id);
    }

}
