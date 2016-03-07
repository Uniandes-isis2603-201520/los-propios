/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.converters;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import edu.uniandes.lospropios.resources.exceptions.ParadaLogicException;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author mc.hernandez1
 */
@Provider
public class ParadaLogicExceptionMapper implements ExceptionMapper<ParadaLogicException>{
    @Override
    public Response toResponse(ParadaLogicException exception) {

        return Response
                .status(Response.Status.NOT_FOUND) // estado HTTP 404
                .entity(exception.getMessage()) // mensaje adicional
                .type("text/plain")
                .build();
    }

}
