/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.converters;

import edu.uniandes.lospropios.resources.exceptions.VisitaLogicException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author josedanielcardenasrincon
 */
public class VisitaExceptionLogicMapper implements ExceptionMapper<VisitaLogicException>{
    
    @Override
    public Response toResponse(VisitaLogicException exception) {
        
        return Response
                .status(Response.Status.NOT_FOUND) // estado HTTP 404
                .entity(exception.getMessage()) // mensaje adicional
                .type("text/plain")
                .build();
    }
    
}
