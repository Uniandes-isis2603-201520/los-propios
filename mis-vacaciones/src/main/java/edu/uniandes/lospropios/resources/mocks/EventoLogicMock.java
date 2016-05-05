/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.lospropios.resources.mocks;

import edu.uniandes.lospropios.resources.dtos.EventoDTO;
import edu.uniandes.lospropios.resources.exceptions.EventoLogicException;
import java.util.ArrayList;
import java.util.Date;
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
    private final static Logger LOGGER = Logger.getLogger(EventoLogicMock.class.getName());
    private final static String ERROR = "No existe un evento con ese id";

    // listado de ciudades
    private static ArrayList<EventoDTO> eventos;

    public EventoLogicMock() {

        if (eventos == null) {
            eventos = new ArrayList<>();
            EventoDTO e1 = new EventoDTO();
            e1.setId(1L);
            e1.setName("evento1");
            e1.setDescripcion("A");
            e1.setLugar("COL");
            e1.setFecha(new Date());
            e1.setPrecio(2000.);
            e1.setImg("http://UrlImg.com");
            e1.setClasificacion(EventoDTO.EVENTO);
            eventos.add(e1);

            e1.setId(2L);
            e1.setName("evento2");
            e1.setDescripcion("B");
            e1.setLugar("FRA");
            e1.setFecha(new Date());
            e1.setPrecio(2001.);
            e1.setImg("http://UrlImg.com");
            e1.setClasificacion(EventoDTO.SITIO_INTERES);
            eventos.add(e1);

            e1.setId(3L);
            e1.setName("evento3");
            e1.setDescripcion("C");
            e1.setLugar("CHI");
            e1.setFecha(new Date());
            e1.setPrecio(20.);
            e1.setImg("http://UrlImg.com");
            e1.setClasificacion(EventoDTO.EVENTO);
            eventos.add(e1);
        }

        // indica que se muestren todos los mensajes
        LOGGER.setLevel(Level.INFO);

        // muestra información
        LOGGER.info("Inicializa la lista de ciudades");
        LOGGER.info("ciudades" + eventos);

    }

    public List<EventoDTO> getEventos() throws EventoLogicException {
        if (eventos == null) {
            LOGGER.severe("Error interno: lista de ciudades no existe.");
            throw new EventoLogicException("Error interno: lista de ciudades no existe.");
        }

        LOGGER.info("retornando todas las ciudades");
        return eventos;

    }

     public EventoDTO getEvento(Long idEvento) throws EventoLogicException {
        LOGGER.info("recibiendo solicitud de itinerario con id " + idEvento);

        // busca el evento con el id suministrado
        for (EventoDTO evento : eventos) {
            if (Objects.equals(evento.getId(), idEvento)) {
                LOGGER.info("retornando itinerario " + evento);
                return evento;
            }
        }

        // si no encuentra el evento
        LOGGER.severe(ERROR);
        throw new EventoLogicException(ERROR);
    }

    public EventoDTO createEvento(EventoDTO evento) throws EventoLogicException {

        LOGGER.info("recibiendo solicitud de agregar ciudad " + evento);

        // el nuevo evento tiene id ?
        if (evento.getId() != null) {
            // busca el vento con el id suministrado
            for (EventoDTO actual : eventos) {
                // si existe un evento con ese id
                if (Objects.equals(actual.getId(), evento.getId())) {
                    LOGGER.severe("Ya existe un evento con ese id");
                    throw new EventoLogicException("Ya existe un evento con ese id");
                }
            }

            // el nuevo evento no tiene id ?
        } else {

            // genera un id para el evento
            LOGGER.info("Generando id para el nuevo evento");
            long newId = 1;
            for (EventoDTO actual : eventos) {
                if (newId <= actual.getId()) {
                    newId = actual.getId() + 1;
                }
            }
            evento.setId(newId);
        }

        // agrega el evento
        LOGGER.info("agregando evento " + evento);
        eventos.add(evento);
        return evento;

    }

    public void deleteEvento(Long id) throws EventoLogicException {

        LOGGER.info("recibiendo solictud de eliminar evento con id " + id);

        // busca el evento con el id suministrado
        for (EventoDTO actual : eventos) {
            if (Objects.equals(actual.getId(), id)) {

                // elimina el evento
                LOGGER.info("eliminando evento " + actual);
                eventos.remove(actual);
                return;
            }
        }

        // no encontró el evento con ese id ?
        LOGGER.severe(ERROR);
        throw new EventoLogicException(ERROR);
    }

    public EventoDTO updateEvento(Long id, EventoDTO evento) throws EventoLogicException {

        LOGGER.info("recibiendo solictud de modificar evento " + evento);

        // busca el evento con el id suministrado
        for (EventoDTO actual : eventos) {
            if (Objects.equals(actual.getId(), id)) {

                // modifica el evento
                actual.setId(evento.getId());
                actual.setName(evento.getName());

                // retorna el evento modificada
                LOGGER.info("Modificando evento " + actual);
                return actual;
            }
        }

        // no encontró el evento con ese id ?
        LOGGER.severe(ERROR);
        throw new EventoLogicException(ERROR);
    }
}
