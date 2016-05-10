/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.resources;

import co.edu.uniandes.mis.vacaciones.logic.api.IPerfilLogic;
import co.edu.uniandes.mis.vacaciones.logic.entities.PerfilEntity;
import co.edu.uniandes.mis.vacaciones.logic.exceptions.BusinessLogicException;
import edu.uniandes.lospropios.resources.converters.PerfilConverter;
import edu.uniandes.lospropios.resources.dtos.PerfilDTO;
import edu.uniandes.lospropios.resources.exceptions.PerfilLogicException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Esta es la informacion de cada viajero, el perfil de cada uno de los usuarios
@Path("perfilesUsuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PerfilResource {

    @Inject
    IPerfilLogic perfilLogic;

    private static final Logger LOGGER = Logger.getLogger(PerfilResource.class.getName());

    //Da el primer perfil de un viajero que encuentra
    @GET
    public List<PerfilDTO> getPerfiles() throws PerfilLogicException {
        LOGGER.info("Se ejecuta el método getPerfil");
        List<PerfilDTO> dto = PerfilConverter.listEntity2DTO(perfilLogic.getPerfiles());
        return dto;
    }

    //Unico perfil
    @GET
    @Path("{id: \\d+}")
    public PerfilDTO getPerfil(@PathParam("id") Long id) throws PerfilLogicException {
        LOGGER.log(Level.INFO, "Se ejecuta método getPerfil con id={0}", id);
        PerfilEntity perfil = perfilLogic.getPerfil(id);
        return PerfilConverter.fullEntity2DTO(perfil);
    }

    @POST
    public PerfilDTO createPerfil(PerfilDTO perfil) throws PerfilLogicException {
        LOGGER.log(Level.INFO, "se crea un perfil: " + perfil );
        PerfilEntity entity = PerfilConverter.fullDTO2Entity(perfil);
        PerfilEntity rta;
        try {
            LOGGER.log(Level.INFO, "Supuestamente esta el entity" + (entity==null));
            LOGGER.log(Level.INFO, "Supuestamente esta el entity x2 " + entity.getName());
            rta = perfilLogic.createPerfil(entity);
            return PerfilConverter.fullEntity2DTO(rta);
        } catch (BusinessLogicException ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
            throw new WebApplicationException(ex.getLocalizedMessage(), ex, Response.Status.BAD_REQUEST);
        }
    }

    @PUT
    @Path("{id: \\d+}")
    public PerfilDTO updatePerfil(@PathParam("id") Long id, PerfilDTO perfil) throws PerfilLogicException {
        LOGGER.log(Level.INFO, "Se ejecuta método updateBook con id={0}", id);
        PerfilEntity entity = PerfilConverter.fullDTO2Entity(perfil);
        entity.setId(id);
        PerfilEntity oldEntity = perfilLogic.getPerfil(id);
        //set listas
        // entity.setAuthors(oldEntity.getAuthors());
        try {
            PerfilEntity savedBook = perfilLogic.updatePerfil(entity);
            return PerfilConverter.fullEntity2DTO(savedBook);
        } catch (BusinessLogicException ex) {
            LOGGER.log(Level.SEVERE, ex.getLocalizedMessage(), ex);
            throw new WebApplicationException(ex.getLocalizedMessage(), ex, Response.Status.BAD_REQUEST);
        }
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteCity(@PathParam("id") Long id) throws PerfilLogicException {
        LOGGER.log(Level.INFO, "Se ejecuta método deleteBook con id={0}", id);
        perfilLogic.deletePerfil(id);
    }

}
