/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.converters;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import edu.uniandes.lospropios.resources.exceptions.CiudadLogicException;

/**
 *
 * @author s.trujillo10
 */
@Provider
public class CiudadLogicExceptionMapper implements ExceptionMapper<CiudadLogicException>{

    /**
     * Generador de una respuesta a partir de una excepción
     *
     * @param ex excecpión a convertir a una respuesta REST
     */
    @Override
    public Response toResponse(CiudadLogicException ex) {
        // retorna una respuesta
        return Response
                .status(Response.Status.NOT_FOUND) // estado HTTP 404
                .entity(ex.getMessage()) // mensaje adicional
                .type("text/plain")
                .build();
    }
}
