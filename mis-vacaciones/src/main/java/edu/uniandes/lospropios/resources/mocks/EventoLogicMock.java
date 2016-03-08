/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.mocks;

import edu.uniandes.lospropios.resources.dtos.CiudadDTO;
import edu.uniandes.lospropios.resources.dtos.EventoDTO;
import edu.uniandes.lospropios.resources.exceptions.EventoLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author js.gomez14
 */
@Named
@ApplicationScoped
public class EventoLogicMock {

    // objeto para presentar logs de las operaciones
    private final static Logger logger = Logger.getLogger(EventoLogicMock.class.getName());

    // listado de ciudades
    private static ArrayList<EventoDTO> eventos;

    public EventoLogicMock() {

    	if (eventos == null) {
            eventos = new ArrayList<>();
            eventos.add(new EventoDTO(1L, "evento1"));
            eventos.add(new EventoDTO(2L, "evento2"));
            eventos.add(new EventoDTO(3L, "evento3"));
        }

    	// indica que se muestren todos los mensajes
    	logger.setLevel(Level.INFO);

    	// muestra información
    	logger.info("Inicializa la lista de ciudades");
    	logger.info("ciudades" + eventos );


    }

    public List<EventoDTO> getEventos() throws EventoLogicException {
        if (eventos == null) {
    		logger.severe("Error interno: lista de ciudades no existe.");
    		throw new EventoLogicException("Error interno: lista de ciudades no existe.");
    	}

    	logger.info("retornando todas las ciudades");
    	return eventos;

    }

    public EventoDTO createEvento(EventoDTO evento) throws EventoLogicException {

            	logger.info("recibiendo solicitud de agregar ciudad " + evento);

    	// la nueva ciudad tiene id ?
    	if ( evento.getId() != null ) {
	    	// busca la ciudad con el id suministrado
	        for (EventoDTO actual : eventos) {
	        	// si existe una ciudad con ese id
	            if (Objects.equals(actual.getId(), evento.getId())){
	            	logger.severe("Ya existe una ciudad con ese id");
	                throw new EventoLogicException("Ya existe una ciudad con ese id");
	            }
	        }

	    // la nueva ciudad no tiene id ?
    	} else {

    		// genera un id para la ciudad
    		logger.info("Generando id paa la nueva ciudad");
    		long newId = 1;
	        for (EventoDTO actual : eventos) {
	            if (newId <= actual.getId()){
	                newId =  actual.getId() + 1;
	            }
	        }
	        evento.setId(newId);
    	}

        // agrega la ciudad
    	logger.info("agregando ciudad " + evento);
        eventos.add(evento);
        return evento;

    }

    public void deleteEvento(Long id) throws EventoLogicException {

            	logger.info("recibiendo solictud de eliminar ciudad con id " + id);

    	// busca la ciudad con el id suministrado
        for (EventoDTO actual : eventos) {
            if (Objects.equals(actual.getId(), id)) {

            	// elimina la ciudad
            	logger.info("eliminando ciudad " + actual);
                eventos.remove(actual);
                return;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new EventoLogicException("No existe una ciudad con ese id");
    }

    public EventoDTO updateEvento(Long id, EventoDTO evento) throws EventoLogicException {

        logger.info("recibiendo solictud de modificar ciudad " + evento);

    	// busca la ciudad con el id suministrado
        for (EventoDTO actual : eventos) {
            if (Objects.equals(actual.getId(), id)) {

            	// modifica la ciudad
            	actual.setId(evento.getId());
                actual.setName(evento.getName());

                // retorna la ciudad modificada
            	logger.info("Modificando ciudad " + actual);
                return actual;
            }
        }

        // no encontró la ciudad con ese id ?
        logger.severe("No existe una ciudad con ese id");
        throw new EventoLogicException("No existe una ciudad con ese id");
    }
}
